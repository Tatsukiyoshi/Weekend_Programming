. .\core.ps1 
. .\config.ps1
write-host 初期化中

####　初期化
$erroractionpreference = 'silent'
settingInstallFolder

resettingProxy

if(test-path $scoop){
scoop cleanup scoop
scoop checkup scoop
scoop uninstall scoop
}
remove-item $env:userprofile\AppData\Local\*scoop* -r



write-host "===========初期化完了============"
