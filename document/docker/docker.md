# Docker コマンド

- コンテナへのログイン <BR>
docker -it <コンテナID> /bin/bash

- コンテナとホスト間のコピー
  - docker cp <コンテナID>:<ファイルパス列> <ホスト内ディレクトリ>
  - docker cp <ホスト内ディレクトリ> <コンテナID>:<ファイルパス列>
