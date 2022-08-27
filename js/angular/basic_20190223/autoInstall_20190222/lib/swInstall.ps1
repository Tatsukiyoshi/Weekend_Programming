. .\config.ps1

settingInstallFolder
settingProxy

$ErrorActionPreference = "Stop"

$LOGFILE='log.txt'


if($psversiontable.psversion.major -lt 3){
    write-host "Powershell ver3以上が必要です"
    exit 1
}

$line="`n==================================================`n"

function log($msg){
    $tmp ="`n"+ (get-date -Format g)+$line+$msg+$line
    Write-Host $tmp -ForegroundColor yellow
    # $tmp 
}

function rmItem($pathStr){
  if($pathStr.Length -eq 0){
 return;
 }
  if(Test-path $pathStr){
  remove-item  $pathStr -Force -Recurse
  }
}

#log('### アンチウイルスを一部制限')
#Add-MpPreference -ExclusionPath '["$env:programdata\scoop", "$env:scoop"]'

#更新に必要なパッケージ
#scoop install git

#パッケージの更新
scoop update git

scoop update

scoop update *

#log('###node.js長期サポート版のインストール')
#scoop install nodejs-lte

#log('###拡張レポジトリーの追加')
scoop bucket add extras

log('###テキストエディタのインストール')
scoop install notepadplusplus

log('###Visual Studio Codeのインストール')
scoop install vscode

log('###Visual Studio Code日本語言語パックのインストール')
code --install-extension ms-ceintl.vscode-language-pack-ja

#log('###Go言語のインストール')
#$env:goroot="$env:USERPROFILE\scoop"
#scoop install go

#log('###自己認証局ツール minicaダウンロード')
#rmItem ("$env:USERPROFILE\scoop\minica")
#git clone https://github.com/jsha/minica "$env:USERPROFILE\scoop\minica"

#log('###自己認証局ツールminicaを実行')
#go run "$env:USERPROFILE\scoop\minica\main.go" --domains localhost --ip-addresses 127.0.0.1

#log('###自己認証局の証明書をブラウザへ登録')
#certutil -addstore ROOT "$env:USERPROFILE\scoop\minica\minica.pem"

log('###npm　キャッシュの検証')
npm cache verify

log('###Angular CLIインストール7.1.4')
npm install -g @angular/cli@7.1.4

log('###npm　キャッシュの検証')
npm cache verify

log('###http-server インストール')
npm install -g http-server

log('###npm バイナリービルド・ツール　インストール')
npm install -g windows-build-tools


#log('### アンチウイルスの制限解除')
#Remove-MpPreference -ExclusionPath '["$env:programdata\scoop", "$env:scoop"]'

write-host "=============インストール完了=============="