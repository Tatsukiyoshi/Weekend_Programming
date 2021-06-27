. .\core.ps1 
. .\config.ps1

write-host インストール開始

####ログの記録開始
Start-Transcript -path "log.txt"

settingInstallFolder

$erroractionpreference = 'stop'

####
# requires -v 3

# remote install:
#   iex (new-object net.webclient).downloadstring('https://get.scoop.sh')
$old_erroractionpreference = $erroractionpreference
$erroractionpreference = 'stop' # quit if anything goes wrong

if(($PSVersionTable.PSVersion.Major) -lt 3) {
    Write-Output "PowerShell 3 or greater is required to run Scoop."
    Write-Output "Upgrade PowerShell: https://docs.microsoft.com/en-us/powershell/scripting/setup/installing-windows-powershell"
    break
}
# show notification to change execution policy:
if((Get-ExecutionPolicy) -gt 'RemoteSigned' -or (Get-ExecutionPolicy) -eq 'ByPass') {
    Write-Output "PowerShell requires an execution policy of 'RemoteSigned' to run Scoop."
    Write-Output "To make this change please run:"
    Write-Output "'Set-ExecutionPolicy RemoteSigned -scope CurrentUser'"
    break
}

if([System.Enum]::GetNames([System.Net.SecurityProtocolType]) -notcontains 'Tls12') {
    Write-Output "Scoop requires at least .NET Framework 4.5"
    Write-Output "Please download and install it first:"
    Write-Output "https://www.microsoft.com/net/download"
    break
}

# get core functions
#$core_url = 'https://raw.github.com/lukesampson/scoop/master/lib/core.ps1'
#Write-Output 'Initializing...'
#$coreFile=Get-Item -Path .\core.ps1
#Invoke-Expression $coreFile.ToString()
#Invoke-Expression (new-object net.webclient).downloadstring($core_url)
#powershell  -file  .\core.ps1
# prep
#if(installed 'scoop') {
 #   write-host "Scoop is already installed. Run 'scoop update' to get the latest version." -f red
    # don't abort if invoked with iex that would close the PS session
  #  if($myinvocation.mycommand.commandtype -eq 'Script') { return } else { exit 1 }
#}
$dir = ensure (versiondir 'scoop' 'current')
#$dir="$env:USERPROFILE\scoop"

# download scoop zip
#$zipurl = 'https://github.com/lukesampson/scoop/archive/master.zip'
$zipfile = "$dir\scoop.zip"
#Write-Output 'Downloading...'
#dl $zipurl $zipfile
copy scoop.zip $zipfile
'Extracting...'
extract_zip $zipfile "$dir\_tmp"
Copy-Item "$dir\_tmp\scoop-master\*" $dir -r -force
Remove-Item "$dir\_tmp" -r -force
Remove-Item $zipfile

Write-Output 'Creating shim...'
shim "$dir\bin\scoop.ps1" $false

 
ensure_robocopy_in_path
ensure_scoop_in_path
scoop config lastupdate ([System.DateTime]::Now.ToString('o'))
success 'Scoop was installed successfully!'
Write-Output "Type 'scoop help' for instructions."

$erroractionpreference = $old_erroractionpreference # Reset $erroractionpreference to original value


scoop install git

scoop install nodejs-lts



write-host "===========loader準備完了============"

#.\swInstall.ps1