# どのイメージを基にするか
FROM ubuntu:22.04

# 作成したユーザの情報
LABEL maintainter="kuboshu83"

# sshサーバをインストールします
RUN apt-get update && apt-get install -y openssh-server
# これが無いとsshdが起動しないっぽい
RUN mkdir /var/run/sshd
# rootのパスワードをrootpasswdに設定します。ただし、公開鍵認証でのアクセスなので使用しませんが。。
RUN echo 'root:rootpassws' | chpasswd
# sshのrootでのアクセスを許可します。ただし、パスワードでのアクセスは無効
RUN sed -i 's/#PermitRootLogin prohibit-password/PermitRootLogin prohibit-password/' /etc/ssh/sshd_config
# sshのポートを22 => 20022に変更します
RUN sed -i 's/#Port 22/Port 20022/' /etc/ssh/sshd_config
# ホスト側にある公開鍵をイメージ側に登録します
COPY ./config_files/id_rsa.pub /root/.ssh/authorized_keys

EXPOSE 20022
CMD ["/usr/sbin/sshd", "-D"]
