cd /d %~dp0lib

call powershell -ExecutionPolicy RemoteSigned -File .\reflesh.ps1

pause
