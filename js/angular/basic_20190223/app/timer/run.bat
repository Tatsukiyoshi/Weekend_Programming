@echo on

rem �T�[�o�[�N��
cd %~dp0timerServer
start node index.js

rem �T�[�o�[�̋N����10�b�ԑҋ@
timeout /T 10

rem �u���E�U���J��
start https://localhost/public/init.html
rem start https://localhost/list

exit