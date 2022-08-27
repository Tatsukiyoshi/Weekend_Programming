
$V_PROXY=''
$V_RESET=0

#---------------------------------------------
#proxy設定例
# $V_PROXY='http://xxx.xxxx.xxxx:ポート番号'
# $V_PROXY='http://192.168.1.100:9900'
# $V_PROXY='http://staffnet.co.jp:8800'
#---------------------------------------------

#$cwd=[System.IO.Directory]::GetCurrentDirectory()

$installFolder="$env:userprofile\scoop"


function settingInstallFolder() {


$customize=$true

if($customize){


write-host "===========インストール先設定開始============"


[environment]::setEnvironmentVariable('SCOOP',$installFolder,'User')
$env:SCOOP=$installFolder
# $cwd=$MyInvocation.MyCommand.Path.
$env:path +=";$installFolder\shim;$installFolder;"


write-host "===========インストール先設定完了開始============"

}
}

###プロキシ
function settingProxy(){

write-host "===========プロキシ設定開始============"

$V_PROXY=$V_PROXY.trim()

if($V_PROXY.length -ne 0){

  if($V_PROXY.contains('http:')){
    npm --global config set http.proxy $V_PROXY
    git config  --global http.proxy $V_PROXY
  }
  if($V_PROXY.contains('https:')){
    npm --global config set https.proxy $V_PROXY
    git config --global https.proxy $V_PROXY
  }
npm -g config set registry http://registry.npmjs.org/
scoop config proxy $V_PROXY
scoop update
}
write-host "===========プロキシ設定完了============"

}

### proxy設定解除

function resettingProxy(){

if($V_PROXY.length -ne 0){
write-host "===========プロキシ解除開始============"

git config --global --unset http.proxy
git config --global --unset https.proxy
git config --list

npm -g config delete proxy
npm -g config delete https-proxy
npm -g config delete registry
npm -g config list

scoop config rm proxy
scoop update

write-host "===========プロキシ解除完了============"
}

}