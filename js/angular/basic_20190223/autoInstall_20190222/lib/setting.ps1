$value=Read-Host "メニュー番号を入力してください?"
write-host 1.システムリセット
write-host 2.プロキシ設定
write-host 3.プロキシ解除
write-host 4.ログ表示


switch ($vlue) {
    1 {"
	
$erroractionpreference = 'silent'
resettingProxy
if($setting-reset)
if(test-path $scoop){
scoop cleanup scoop
scoop checkup scoop
scoop uninstall scoop
remove-item $env:userprofile\AppData\Local\*scoop* -r

..\lib^

}


	
    2 {"settingProxy
	host-write lib\config.ps1をテキストエディタで開き、	先頭行にアドレスを記入記入してください。"}"}
    3 {"resettingProxy"}
	4 {"3"}}