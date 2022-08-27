cd /d %~dp0lib

call powershell -ExecutionPolicy RemoteSigned -File .\loader_setup.ps1

call powershell -ExecutionPolicy RemoteSigned -File .\swInstall.ps1

pause
