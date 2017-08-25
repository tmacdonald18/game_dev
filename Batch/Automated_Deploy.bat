@echo off
REM Exports/imports a process and its associated VBOs from/to BP server of choice

setlocal enabledelayedexpansion

REM Initial setup:
for /F "tokens=1,2 delims==" %%a in (config.txt) do (
	if "%%a"=="server" (set server=%%b)
	if "%%a"=="option" (set option=%%b)
	if "%%a"=="process" (set process=%%b)
	if "%%a"=="overwrite" (set overwrite=%%b)
)

echo. >> "log_file.txt"
echo -------------------------------------------------------------- >> "log_file.txt"
echo %option% from %server% at %DATE%  %TIME% >> "log_file.txt"
echo -------------------------------------------------------------- >> "log_file.txt"

echo server=%server% process=%process% option=%option% overwrite=%overwrite% >> "log_file.txt"

REM If choosing to export, export process, then parse exported xml for VBOs, then export those parsed VBOs
if "%option%"=="export" ( 
	echo Exported Process: %process% >> "log_file.txt"
	"C:\Program Files\Blue Prism Limited\Blue Prism Automate\automateC.exe" /export %process% /dbconname %server% /sso

	REM Get newest file in directory by looping through them sorted from oldest to newest
	REM Save the last file found (which should be the newest one based on the sort) to a variable
	for /f "tokens=*" %%a in ('dir /b /od') do (
		set newest=%%a
	)

	for /F tokens^=2^ delims^=^"  %%c in ('FINDSTR /C:"object=" "!newest!"') do (
		If Not Exist "BPA Object - %%c.xml" (
			"C:\Program Files\Blue Prism Limited\Blue Prism Automate\automateC.exe" /export "%%c" /dbconname %server% /sso
			echo     Exported Object: %%c >> log_file.txt
		)
	)
)

if "%option%"=="import" (
	"C:\Program Files\Blue Prism Limited\Blue Prism Automate\automateC.exe" /import %process% /dbconname %server% /sso %overwrite%
	echo Imported Process File: %process% >> "log_file.txt"
	
	for /F tokens^=2^ delims^=^" %%c in ('FINDSTR /C:"object=" %process%') do (
		If Not Exist "BPA Object - %%c.xml" (
			echo     ERROR: Could not find xml for %%c >> log_file.txt
		)
		If Exist "BPA Object - %%c.xml" (
			"C:\Program Files\Blue Prism Limited\Blue Prism Automate\automateC.exe" /import "BPA Object - %%c.xml" /dbconname %server% /sso %overwrite%
			echo     Imported Object File: "BPA Object - %%c.xml" >> log_file.txt
		)
	)
)

echo -------------------------------------------------------------- >> "log_file.txt"
echo Automation ended at %DATE%  %TIME% >> "log_file.txt"
echo -------------------------------------------------------------- >> "log_file.txt"
