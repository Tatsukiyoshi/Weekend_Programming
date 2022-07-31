*   carbonは、LinuxまたはMac OSが必要。
    *   WindowsのWSL2であれば、Linux環境が構築できるので、Ubuntu22.04にインストールすることに。
        -   homebrewをインストール
            ```
            /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
            ```

            ### インストールログ
            ```
            taishow@IdeaPad550-2022:~$ /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
            ==> Checking for `sudo` access (which may request your password)...
            ==> Select a Homebrew installation directory:
            - Enter your password to install to /home/linuxbrew/.linuxbrew (recommended)
            - Press Control-D to install to /home/taishow/.linuxbrew
            - Press Control-C to cancel installation
            [sudo] password for taishow:
            ==> This script will install:
            /home/linuxbrew/.linuxbrew/bin/brew
            /home/linuxbrew/.linuxbrew/share/doc/homebrew
            /home/linuxbrew/.linuxbrew/share/man/man1/brew.1
            /home/linuxbrew/.linuxbrew/share/zsh/site-functions/_brew
            /home/linuxbrew/.linuxbrew/etc/bash_completion.d/brew
            /home/linuxbrew/.linuxbrew/Homebrew
            ==> The following new directories will be created:
            /home/linuxbrew/.linuxbrew/bin
            /home/linuxbrew/.linuxbrew/etc
            /home/linuxbrew/.linuxbrew/include
            /home/linuxbrew/.linuxbrew/lib
            /home/linuxbrew/.linuxbrew/sbin
            /home/linuxbrew/.linuxbrew/share
            /home/linuxbrew/.linuxbrew/var
            /home/linuxbrew/.linuxbrew/opt
            /home/linuxbrew/.linuxbrew/share/zsh
            /home/linuxbrew/.linuxbrew/share/zsh/site-functions
            /home/linuxbrew/.linuxbrew/var/homebrew
            /home/linuxbrew/.linuxbrew/var/homebrew/linked
            /home/linuxbrew/.linuxbrew/Cellar
            /home/linuxbrew/.linuxbrew/Caskroom
            /home/linuxbrew/.linuxbrew/Frameworks

            Press RETURN/ENTER to continue or any other key to abort:
            ==> /usr/bin/sudo /usr/bin/install -d -o taishow -g taishow -m 0755 /home/linuxbrew/.linuxbrew
            ==> /usr/bin/sudo /bin/mkdir -p /home/linuxbrew/.linuxbrew/bin /home/linuxbrew/.linuxbrew/etc /home/linuxbrew/.linuxbrew/include /home/linuxbrew/.linuxbrew/lib /home/linuxbrew/.linuxbrew/sbin /home/linuxbrew/.linuxbrew/share /home/linuxbrew/.linuxbrew/var /home/linuxbrew/.linuxbrew/opt /home/linuxbrew/.linuxbrew/share/zsh /home/linuxbrew/.linuxbrew/share/zsh/site-functions /home/linuxbrew/.linuxbrew/var/homebrew /home/linuxbrew/.linuxbrew/var/homebrew/linked /home/linuxbrew/.linuxbrew/Cellar /home/linuxbrew/.linuxbrew/Caskroom /home/linuxbrew/.linuxbrew/Frameworks
            ==> /usr/bin/sudo /bin/chmod ug=rwx /home/linuxbrew/.linuxbrew/bin /home/linuxbrew/.linuxbrew/etc /home/linuxbrew/.linuxbrew/include /home/linuxbrew/.linuxbrew/lib /home/linuxbrew/.linuxbrew/sbin /home/linuxbrew/.linuxbrew/share /home/linuxbrew/.linuxbrew/var /home/linuxbrew/.linuxbrew/opt /home/linuxbrew/.linuxbrew/share/zsh /home/linuxbrew/.linuxbrew/share/zsh/site-functions /home/linuxbrew/.linuxbrew/var/homebrew /home/linuxbrew/.linuxbrew/var/homebrew/linked /home/linuxbrew/.linuxbrew/Cellar /home/linuxbrew/.linuxbrew/Caskroom /home/linuxbrew/.linuxbrew/Frameworks
            ==> /usr/bin/sudo /bin/chmod go-w /home/linuxbrew/.linuxbrew/share/zsh /home/linuxbrew/.linuxbrew/share/zsh/site-functions
            ==> /usr/bin/sudo /bin/chown taishow /home/linuxbrew/.linuxbrew/bin /home/linuxbrew/.linuxbrew/etc /home/linuxbrew/.linuxbrew/include /home/linuxbrew/.linuxbrew/lib /home/linuxbrew/.linuxbrew/sbin /home/linuxbrew/.linuxbrew/share /home/linuxbrew/.linuxbrew/var /home/linuxbrew/.linuxbrew/opt /home/linuxbrew/.linuxbrew/share/zsh /home/linuxbrew/.linuxbrew/share/zsh/site-functions /home/linuxbrew/.linuxbrew/var/homebrew /home/linuxbrew/.linuxbrew/var/homebrew/linked /home/linuxbrew/.linuxbrew/Cellar /home/linuxbrew/.linuxbrew/Caskroom /home/linuxbrew/.linuxbrew/Frameworks
            ==> /usr/bin/sudo /bin/chgrp taishow /home/linuxbrew/.linuxbrew/bin /home/linuxbrew/.linuxbrew/etc /home/linuxbrew/.linuxbrew/include /home/linuxbrew/.linuxbrew/lib /home/linuxbrew/.linuxbrew/sbin /home/linuxbrew/.linuxbrew/share /home/linuxbrew/.linuxbrew/var /home/linuxbrew/.linuxbrew/opt /home/linuxbrew/.linuxbrew/share/zsh /home/linuxbrew/.linuxbrew/share/zsh/site-functions /home/linuxbrew/.linuxbrew/var/homebrew /home/linuxbrew/.linuxbrew/var/homebrew/linked /home/linuxbrew/.linuxbrew/Cellar /home/linuxbrew/.linuxbrew/Caskroom /home/linuxbrew/.linuxbrew/Frameworks
            ==> /usr/bin/sudo /bin/mkdir -p /home/linuxbrew/.linuxbrew/Homebrew
            ==> /usr/bin/sudo /bin/chown -R taishow:taishow /home/linuxbrew/.linuxbrew/Homebrew
            ==> Downloading and installing Homebrew...
            remote: Enumerating objects: 212766, done.
            remote: Counting objects: 100% (79/79), done.
            remote: Compressing objects: 100% (65/65), done.
            remote: Total 212766 (delta 23), reused 66 (delta 14), pack-reused 212687
            Receiving objects: 100% (212766/212766), 59.17 MiB | 895.00 KiB/s, done.
            Resolving deltas: 100% (156462/156462), done.
            From https://github.com/Homebrew/brew
            * [new branch]          dependabot/bundler/Library/Homebrew/sorbet-static-and-runtime-0.5.10172 -> origin/dependabot/bundler/Library/Homebrew/sorbet-static-and-runtime-0.5.10172
            * [new branch]          master     -> origin/master
            * [new tag]             0.1        -> 0.1
            * [new tag]             0.2        -> 0.2
            * [new tag]             0.3        -> 0.3
            * [new tag]             0.4        -> 0.4
            * [new tag]             0.5        -> 0.5
            * [new tag]             0.6        -> 0.6
            * [new tag]             0.7        -> 0.7
            * [new tag]             0.7.1      -> 0.7.1
            * [new tag]             0.8        -> 0.8
            * [new tag]             0.8.1      -> 0.8.1
            * [new tag]             0.9        -> 0.9
            * [new tag]             0.9.1      -> 0.9.1
            * [new tag]             0.9.2      -> 0.9.2
            * [new tag]             0.9.3      -> 0.9.3
            * [new tag]             0.9.4      -> 0.9.4
            * [new tag]             0.9.5      -> 0.9.5
            * [new tag]             0.9.8      -> 0.9.8
            * [new tag]             0.9.9      -> 0.9.9
            * [new tag]             1.0.0      -> 1.0.0
            * [new tag]             1.0.1      -> 1.0.1
            * [new tag]             1.0.2      -> 1.0.2
            * [new tag]             1.0.3      -> 1.0.3
            * [new tag]             1.0.4      -> 1.0.4
            * [new tag]             1.0.5      -> 1.0.5
            * [new tag]             1.0.6      -> 1.0.6
            * [new tag]             1.0.7      -> 1.0.7
            * [new tag]             1.0.8      -> 1.0.8
            * [new tag]             1.0.9      -> 1.0.9
            * [new tag]             1.1.0      -> 1.1.0
            * [new tag]             1.1.1      -> 1.1.1
            * [new tag]             1.1.10     -> 1.1.10
            * [new tag]             1.1.11     -> 1.1.11
            * [new tag]             1.1.12     -> 1.1.12
            * [new tag]             1.1.13     -> 1.1.13
            * [new tag]             1.1.2      -> 1.1.2
            * [new tag]             1.1.3      -> 1.1.3
            * [new tag]             1.1.4      -> 1.1.4
            * [new tag]             1.1.5      -> 1.1.5
            * [new tag]             1.1.6      -> 1.1.6
            * [new tag]             1.1.7      -> 1.1.7
            * [new tag]             1.1.8      -> 1.1.8
            * [new tag]             1.1.9      -> 1.1.9
            * [new tag]             1.2.0      -> 1.2.0
            * [new tag]             1.2.1      -> 1.2.1
            * [new tag]             1.2.2      -> 1.2.2
            * [new tag]             1.2.3      -> 1.2.3
            * [new tag]             1.2.4      -> 1.2.4
            * [new tag]             1.2.5      -> 1.2.5
            * [new tag]             1.2.6      -> 1.2.6
            * [new tag]             1.3.0      -> 1.3.0
            * [new tag]             1.3.1      -> 1.3.1
            * [new tag]             1.3.2      -> 1.3.2
            * [new tag]             1.3.3      -> 1.3.3
            * [new tag]             1.3.4      -> 1.3.4
            * [new tag]             1.3.5      -> 1.3.5
            * [new tag]             1.3.6      -> 1.3.6
            * [new tag]             1.3.7      -> 1.3.7
            * [new tag]             1.3.8      -> 1.3.8
            * [new tag]             1.3.9      -> 1.3.9
            * [new tag]             1.4.0      -> 1.4.0
            * [new tag]             1.4.1      -> 1.4.1
            * [new tag]             1.4.2      -> 1.4.2
            * [new tag]             1.4.3      -> 1.4.3
            * [new tag]             1.5.0      -> 1.5.0
            * [new tag]             1.5.1      -> 1.5.1
            * [new tag]             1.5.10     -> 1.5.10
            * [new tag]             1.5.11     -> 1.5.11
            * [new tag]             1.5.12     -> 1.5.12
            * [new tag]             1.5.13     -> 1.5.13
            * [new tag]             1.5.14     -> 1.5.14
            * [new tag]             1.5.2      -> 1.5.2
            * [new tag]             1.5.3      -> 1.5.3
            * [new tag]             1.5.4      -> 1.5.4
            * [new tag]             1.5.5      -> 1.5.5
            * [new tag]             1.5.6      -> 1.5.6
            * [new tag]             1.5.7      -> 1.5.7
            * [new tag]             1.5.8      -> 1.5.8
            * [new tag]             1.5.9      -> 1.5.9
            * [new tag]             1.6.0      -> 1.6.0
            * [new tag]             1.6.1      -> 1.6.1
            * [new tag]             1.6.10     -> 1.6.10
            * [new tag]             1.6.11     -> 1.6.11
            * [new tag]             1.6.12     -> 1.6.12
            * [new tag]             1.6.13     -> 1.6.13
            * [new tag]             1.6.14     -> 1.6.14
            * [new tag]             1.6.15     -> 1.6.15
            * [new tag]             1.6.16     -> 1.6.16
            * [new tag]             1.6.17     -> 1.6.17
            * [new tag]             1.6.2      -> 1.6.2
            * [new tag]             1.6.3      -> 1.6.3
            * [new tag]             1.6.4      -> 1.6.4
            * [new tag]             1.6.5      -> 1.6.5
            * [new tag]             1.6.6      -> 1.6.6
            * [new tag]             1.6.7      -> 1.6.7
            * [new tag]             1.6.8      -> 1.6.8
            * [new tag]             1.6.9      -> 1.6.9
            * [new tag]             1.7.0      -> 1.7.0
            * [new tag]             1.7.1      -> 1.7.1
            * [new tag]             1.7.2      -> 1.7.2
            * [new tag]             1.7.3      -> 1.7.3
            * [new tag]             1.7.4      -> 1.7.4
            * [new tag]             1.7.5      -> 1.7.5
            * [new tag]             1.7.6      -> 1.7.6
            * [new tag]             1.7.7      -> 1.7.7
            * [new tag]             1.8.0      -> 1.8.0
            * [new tag]             1.8.1      -> 1.8.1
            * [new tag]             1.8.2      -> 1.8.2
            * [new tag]             1.8.3      -> 1.8.3
            * [new tag]             1.8.4      -> 1.8.4
            * [new tag]             1.8.5      -> 1.8.5
            * [new tag]             1.8.6      -> 1.8.6
            * [new tag]             1.9.0      -> 1.9.0
            * [new tag]             1.9.1      -> 1.9.1
            * [new tag]             1.9.2      -> 1.9.2
            * [new tag]             1.9.3      -> 1.9.3
            * [new tag]             2.0.0      -> 2.0.0
            * [new tag]             2.0.1      -> 2.0.1
            * [new tag]             2.0.2      -> 2.0.2
            * [new tag]             2.0.3      -> 2.0.3
            * [new tag]             2.0.4      -> 2.0.4
            * [new tag]             2.0.5      -> 2.0.5
            * [new tag]             2.0.6      -> 2.0.6
            * [new tag]             2.1.0      -> 2.1.0
            * [new tag]             2.1.1      -> 2.1.1
            * [new tag]             2.1.10     -> 2.1.10
            * [new tag]             2.1.11     -> 2.1.11
            * [new tag]             2.1.12     -> 2.1.12
            * [new tag]             2.1.13     -> 2.1.13
            * [new tag]             2.1.14     -> 2.1.14
            * [new tag]             2.1.15     -> 2.1.15
            * [new tag]             2.1.16     -> 2.1.16
            * [new tag]             2.1.2      -> 2.1.2
            * [new tag]             2.1.3      -> 2.1.3
            * [new tag]             2.1.4      -> 2.1.4
            * [new tag]             2.1.5      -> 2.1.5
            * [new tag]             2.1.6      -> 2.1.6
            * [new tag]             2.1.7      -> 2.1.7
            * [new tag]             2.1.8      -> 2.1.8
            * [new tag]             2.1.9      -> 2.1.9
            * [new tag]             2.2.0      -> 2.2.0
            * [new tag]             2.2.1      -> 2.2.1
            * [new tag]             2.2.10     -> 2.2.10
            * [new tag]             2.2.11     -> 2.2.11
            * [new tag]             2.2.12     -> 2.2.12
            * [new tag]             2.2.13     -> 2.2.13
            * [new tag]             2.2.14     -> 2.2.14
            * [new tag]             2.2.15     -> 2.2.15
            * [new tag]             2.2.16     -> 2.2.16
            * [new tag]             2.2.17     -> 2.2.17
            * [new tag]             2.2.2      -> 2.2.2
            * [new tag]             2.2.3      -> 2.2.3
            * [new tag]             2.2.4      -> 2.2.4
            * [new tag]             2.2.5      -> 2.2.5
            * [new tag]             2.2.6      -> 2.2.6
            * [new tag]             2.2.7      -> 2.2.7
            * [new tag]             2.2.8      -> 2.2.8
            * [new tag]             2.2.9      -> 2.2.9
            * [new tag]             2.3.0      -> 2.3.0
            * [new tag]             2.4.0      -> 2.4.0
            * [new tag]             2.4.1      -> 2.4.1
            * [new tag]             2.4.10     -> 2.4.10
            * [new tag]             2.4.11     -> 2.4.11
            * [new tag]             2.4.12     -> 2.4.12
            * [new tag]             2.4.13     -> 2.4.13
            * [new tag]             2.4.14     -> 2.4.14
            * [new tag]             2.4.15     -> 2.4.15
            * [new tag]             2.4.16     -> 2.4.16
            * [new tag]             2.4.2      -> 2.4.2
            * [new tag]             2.4.3      -> 2.4.3
            * [new tag]             2.4.4      -> 2.4.4
            * [new tag]             2.4.5      -> 2.4.5
            * [new tag]             2.4.6      -> 2.4.6
            * [new tag]             2.4.7      -> 2.4.7
            * [new tag]             2.4.8      -> 2.4.8
            * [new tag]             2.4.9      -> 2.4.9
            * [new tag]             2.5.0      -> 2.5.0
            * [new tag]             2.5.1      -> 2.5.1
            * [new tag]             2.5.10     -> 2.5.10
            * [new tag]             2.5.11     -> 2.5.11
            * [new tag]             2.5.12     -> 2.5.12
            * [new tag]             2.5.2      -> 2.5.2
            * [new tag]             2.5.3      -> 2.5.3
            * [new tag]             2.5.4      -> 2.5.4
            * [new tag]             2.5.5      -> 2.5.5
            * [new tag]             2.5.6      -> 2.5.6
            * [new tag]             2.5.7      -> 2.5.7
            * [new tag]             2.5.8      -> 2.5.8
            * [new tag]             2.5.9      -> 2.5.9
            * [new tag]             2.6.0      -> 2.6.0
            * [new tag]             2.6.1      -> 2.6.1
            * [new tag]             2.6.2      -> 2.6.2
            * [new tag]             2.7.0      -> 2.7.0
            * [new tag]             2.7.1      -> 2.7.1
            * [new tag]             2.7.2      -> 2.7.2
            * [new tag]             2.7.3      -> 2.7.3
            * [new tag]             2.7.4      -> 2.7.4
            * [new tag]             2.7.5      -> 2.7.5
            * [new tag]             2.7.6      -> 2.7.6
            * [new tag]             2.7.7      -> 2.7.7
            * [new tag]             3.0.0      -> 3.0.0
            * [new tag]             3.0.1      -> 3.0.1
            * [new tag]             3.0.10     -> 3.0.10
            * [new tag]             3.0.11     -> 3.0.11
            * [new tag]             3.0.2      -> 3.0.2
            * [new tag]             3.0.3      -> 3.0.3
            * [new tag]             3.0.4      -> 3.0.4
            * [new tag]             3.0.5      -> 3.0.5
            * [new tag]             3.0.6      -> 3.0.6
            * [new tag]             3.0.7      -> 3.0.7
            * [new tag]             3.0.8      -> 3.0.8
            * [new tag]             3.0.9      -> 3.0.9
            * [new tag]             3.1.0      -> 3.1.0
            * [new tag]             3.1.1      -> 3.1.1
            * [new tag]             3.1.10     -> 3.1.10
            * [new tag]             3.1.11     -> 3.1.11
            * [new tag]             3.1.12     -> 3.1.12
            * [new tag]             3.1.2      -> 3.1.2
            * [new tag]             3.1.3      -> 3.1.3
            * [new tag]             3.1.4      -> 3.1.4
            * [new tag]             3.1.5      -> 3.1.5
            * [new tag]             3.1.6      -> 3.1.6
            * [new tag]             3.1.7      -> 3.1.7
            * [new tag]             3.1.8      -> 3.1.8
            * [new tag]             3.1.9      -> 3.1.9
            * [new tag]             3.2.0      -> 3.2.0
            * [new tag]             3.2.1      -> 3.2.1
            * [new tag]             3.2.10     -> 3.2.10
            * [new tag]             3.2.11     -> 3.2.11
            * [new tag]             3.2.12     -> 3.2.12
            * [new tag]             3.2.13     -> 3.2.13
            * [new tag]             3.2.14     -> 3.2.14
            * [new tag]             3.2.15     -> 3.2.15
            * [new tag]             3.2.16     -> 3.2.16
            * [new tag]             3.2.17     -> 3.2.17
            * [new tag]             3.2.2      -> 3.2.2
            * [new tag]             3.2.3      -> 3.2.3
            * [new tag]             3.2.4      -> 3.2.4
            * [new tag]             3.2.5      -> 3.2.5
            * [new tag]             3.2.6      -> 3.2.6
            * [new tag]             3.2.7      -> 3.2.7
            * [new tag]             3.2.8      -> 3.2.8
            * [new tag]             3.2.9      -> 3.2.9
            * [new tag]             3.3.0      -> 3.3.0
            * [new tag]             3.3.1      -> 3.3.1
            * [new tag]             3.3.10     -> 3.3.10
            * [new tag]             3.3.11     -> 3.3.11
            * [new tag]             3.3.12     -> 3.3.12
            * [new tag]             3.3.13     -> 3.3.13
            * [new tag]             3.3.14     -> 3.3.14
            * [new tag]             3.3.15     -> 3.3.15
            * [new tag]             3.3.16     -> 3.3.16
            * [new tag]             3.3.2      -> 3.3.2
            * [new tag]             3.3.3      -> 3.3.3
            * [new tag]             3.3.4      -> 3.3.4
            * [new tag]             3.3.5      -> 3.3.5
            * [new tag]             3.3.6      -> 3.3.6
            * [new tag]             3.3.7      -> 3.3.7
            * [new tag]             3.3.8      -> 3.3.8
            * [new tag]             3.3.9      -> 3.3.9
            * [new tag]             3.4.0      -> 3.4.0
            * [new tag]             3.4.1      -> 3.4.1
            * [new tag]             3.4.10     -> 3.4.10
            * [new tag]             3.4.11     -> 3.4.11
            * [new tag]             3.4.2      -> 3.4.2
            * [new tag]             3.4.3      -> 3.4.3
            * [new tag]             3.4.4      -> 3.4.4
            * [new tag]             3.4.5      -> 3.4.5
            * [new tag]             3.4.6      -> 3.4.6
            * [new tag]             3.4.7      -> 3.4.7
            * [new tag]             3.4.8      -> 3.4.8
            * [new tag]             3.4.9      -> 3.4.9
            * [new tag]             3.5.0      -> 3.5.0
            * [new tag]             3.5.1      -> 3.5.1
            * [new tag]             3.5.2      -> 3.5.2
            * [new tag]             3.5.3      -> 3.5.3
            * [new tag]             3.5.4      -> 3.5.4
            * [new tag]             3.5.5      -> 3.5.5
            * [new tag]             3.5.6      -> 3.5.6
            HEAD is now at e217fd35c Merge pull request #12770 from carlocab/deprecated-dependencies
            ==> Tapping homebrew/core
            remote: Enumerating objects: 1237525, done.
            remote: Counting objects: 100% (114/114), done.
            remote: Compressing objects: 100% (66/66), done.
            remote: Total 1237525 (delta 64), reused 95 (delta 48), pack-reused 1237411
            Receiving objects: 100% (1237525/1237525), 503.24 MiB | 1.09 MiB/s, done.
            Resolving deltas: 100% (851589/851589), done.
            From https://github.com/Homebrew/homebrew-core
            * [new branch]              master     -> origin/master
            HEAD is now at de4c8473175 pigz: update 2.7_1 bottle.
            ==> Downloading https://ghcr.io/v2/homebrew/portable-ruby/portable-ruby/blobs/sha256:fc45ee6eddf4c7a17f4373dde7b1bc8a58255ea61e6847d3bf895225b28d072a
            ######################################################################## 100.0%
            ==> Pouring portable-ruby-2.6.8_1.x86_64_linux.bottle.tar.gz
            Warning: /home/linuxbrew/.linuxbrew/bin is not in your PATH.
            Instructions on how to configure your shell for Homebrew
            can be found in the 'Next steps' section below.
            ==> Installation successful!

            ==> Homebrew has enabled anonymous aggregate formulae and cask analytics.
            Read the analytics documentation (and how to opt-out) here:
            https://docs.brew.sh/Analytics
            No analytics data has been sent yet (nor will any be during this install run).

            ==> Homebrew is run entirely by unpaid volunteers. Please consider donating:
            https://github.com/Homebrew/brew#donations

            ==> Next steps:
            - Run these two commands in your terminal to add Homebrew to your PATH:
                echo 'eval "$(/home/linuxbrew/.linuxbrew/bin/brew shellenv)"' >> /home/taishow/.profile
                eval "$(/home/linuxbrew/.linuxbrew/bin/brew shellenv)"
            - Install Homebrew's dependencies if you have sudo access:
                sudo apt-get install build-essential
            For more information, see:
                https://docs.brew.sh/Homebrew-on-Linux
            - We recommend that you install GCC:
                brew install gcc
            - Run brew help to get started
            - Further documentation:
                https://docs.brew.sh
            ```

            ### gccインストールログ
            ```
            $ brew install gcc
            ==> Downloading https://ghcr.io/v2/homebrew/core/gmp/manifests/6.2.1_1
            ######################################################################## 100.0%
            ==> Downloading https://ghcr.io/v2/homebrew/core/gmp/blobs/sha256:786ae29f0c0b06ea86e42bd9c6ac2c49bd5757da037dead7053e8b
            ==> Downloading from https://pkg-containers.githubusercontent.com/ghcr1/blobs/sha256:786ae29f0c0b06ea86e42bd9c6ac2c49bd5
            ######################################################################## 100.0%
            ==> Downloading https://ghcr.io/v2/homebrew/core/isl/manifests/0.25
            ######################################################################## 100.0%
            ==> Downloading https://ghcr.io/v2/homebrew/core/isl/blobs/sha256:c0244c95ed9cc89b826868de83bec3150fcc120add126501717677
            ==> Downloading from https://pkg-containers.githubusercontent.com/ghcr1/blobs/sha256:c0244c95ed9cc89b826868de83bec3150fc
            ######################################################################## 100.0%
            ==> Downloading https://ghcr.io/v2/homebrew/core/mpfr/manifests/4.1.0
            ######################################################################## 100.0%
            ==> Downloading https://ghcr.io/v2/homebrew/core/mpfr/blobs/sha256:4c5f1cfd038e8fbd640795e34e5e23c11244be3eca7781979600e
            ==> Downloading from https://pkg-containers.githubusercontent.com/ghcr1/blobs/sha256:4c5f1cfd038e8fbd640795e34e5e23c1124
            ######################################################################## 100.0%
            ==> Downloading https://ghcr.io/v2/homebrew/core/libmpc/manifests/1.2.1
            ######################################################################## 100.0%
            ==> Downloading https://ghcr.io/v2/homebrew/core/libmpc/blobs/sha256:d74eb5f1377d8fa72fad88baca1bd5f00c29d45ba186fbec89a
            ==> Downloading from https://pkg-containers.githubusercontent.com/ghcr1/blobs/sha256:d74eb5f1377d8fa72fad88baca1bd5f00c2
            ######################################################################## 100.0%
            ==> Downloading https://ghcr.io/v2/homebrew/core/lz4/manifests/1.9.3
            ######################################################################## 100.0%
            ==> Downloading https://ghcr.io/v2/homebrew/core/lz4/blobs/sha256:902257ec34dd2beebcf22bb68c9ccd179008c2ba8d725436c3c5cd
            ==> Downloading from https://pkg-containers.githubusercontent.com/ghcr1/blobs/sha256:902257ec34dd2beebcf22bb68c9ccd17900
            ######################################################################## 100.0%
            ==> Downloading https://ghcr.io/v2/homebrew/core/xz/manifests/5.2.5_1
            ######################################################################## 100.0%
            ==> Downloading https://ghcr.io/v2/homebrew/core/xz/blobs/sha256:5308bba4329d4ca980f8a2a8cb6b26e746f498e5dc76cc32b02ff97
            ==> Downloading from https://pkg-containers.githubusercontent.com/ghcr1/blobs/sha256:5308bba4329d4ca980f8a2a8cb6b26e746f
            ######################################################################## 100.0%
            ==> Downloading https://ghcr.io/v2/homebrew/core/zlib/manifests/1.2.12
            ######################################################################## 100.0%
            ==> Downloading https://ghcr.io/v2/homebrew/core/zlib/blobs/sha256:23b1d8f0500bbccdf5cc466e7acbd7eddc40cd1465687239af423
            ==> Downloading from https://pkg-containers.githubusercontent.com/ghcr1/blobs/sha256:23b1d8f0500bbccdf5cc466e7acbd7eddc4
            ######################################################################## 100.0%
            ==> Downloading https://ghcr.io/v2/homebrew/core/zstd/manifests/1.5.2-3
            ######################################################################## 100.0%
            ==> Downloading https://ghcr.io/v2/homebrew/core/zstd/blobs/sha256:006b5ab6a4616a8b6f59953cb9efb546d312e3ba231c303bb5674
            ==> Downloading from https://pkg-containers.githubusercontent.com/ghcr1/blobs/sha256:006b5ab6a4616a8b6f59953cb9efb546d31
            ######################################################################## 100.0%
            ==> Downloading https://ghcr.io/v2/homebrew/core/binutils/manifests/2.38_1
            ######################################################################## 100.0%
            ==> Downloading https://ghcr.io/v2/homebrew/core/binutils/blobs/sha256:9a90a33ab3678b5a325d8f5f16470f17a04700717ae936d7d
            ==> Downloading from https://pkg-containers.githubusercontent.com/ghcr1/blobs/sha256:9a90a33ab3678b5a325d8f5f16470f17a04
            ######################################################################## 100.0%
            ==> Downloading https://ghcr.io/v2/homebrew/core/gcc/manifests/11.3.0_2-1
            ######################################################################## 100.0%
            ==> Downloading https://ghcr.io/v2/homebrew/core/gcc/blobs/sha256:e826c10b577ca561cdcef55042c426bc7aabb4a937e5e2aab66c0f
            ==> Downloading from https://pkg-containers.githubusercontent.com/ghcr1/blobs/sha256:e826c10b577ca561cdcef55042c426bc7aa
            ######################################################################## 100.0%
            ==> Installing dependencies for gcc: gmp, isl, mpfr, libmpc, lz4, xz, zlib, zstd and binutils
            ==> Installing gcc dependency: gmp
            ==> Pouring gmp--6.2.1_1.x86_64_linux.bottle.tar.gz
            🍺  /home/linuxbrew/.linuxbrew/Cellar/gmp/6.2.1_1: 23 files, 3.9MB
            ==> Installing gcc dependency: isl
            ==> Pouring isl--0.25.x86_64_linux.bottle.tar.gz
            🍺  /home/linuxbrew/.linuxbrew/Cellar/isl/0.25: 74 files, 9.2MB
            ==> Installing gcc dependency: mpfr
            ==> Pouring mpfr--4.1.0.x86_64_linux.bottle.tar.gz
            🍺  /home/linuxbrew/.linuxbrew/Cellar/mpfr/4.1.0: 31 files, 7.9MB
            ==> Installing gcc dependency: libmpc
            ==> Pouring libmpc--1.2.1.x86_64_linux.bottle.tar.gz
            🍺  /home/linuxbrew/.linuxbrew/Cellar/libmpc/1.2.1: 13 files, 550.0KB
            ==> Installing gcc dependency: lz4
            ==> Pouring lz4--1.9.3.x86_64_linux.bottle.tar.gz
            🍺  /home/linuxbrew/.linuxbrew/Cellar/lz4/1.9.3: 22 files, 643.2KB
            ==> Installing gcc dependency: xz
            ==> Pouring xz--5.2.5_1.x86_64_linux.bottle.tar.gz
            🍺  /home/linuxbrew/.linuxbrew/Cellar/xz/5.2.5_1: 130 files, 1.9MB
            ==> Installing gcc dependency: zlib
            ==> Pouring zlib--1.2.12.x86_64_linux.bottle.tar.gz
            🍺  /home/linuxbrew/.linuxbrew/Cellar/zlib/1.2.12: 12 files, 464.3KB
            ==> Installing gcc dependency: zstd
            ==> Pouring zstd--1.5.2.x86_64_linux.bottle.3.tar.gz
            🍺  /home/linuxbrew/.linuxbrew/Cellar/zstd/1.5.2: 31 files, 2.6MB
            ==> Installing gcc dependency: binutils
            ==> Pouring binutils--2.38_1.x86_64_linux.bottle.tar.gz
            🍺  /home/linuxbrew/.linuxbrew/Cellar/binutils/2.38_1: 4,766 files, 261.1MB
            ==> Installing gcc
            ==> Pouring gcc--11.3.0_2.x86_64_linux.bottle.1.tar.gz
            ==> Creating the GCC specs file: /home/linuxbrew/.linuxbrew/Cellar/gcc/11.3.0_2/bin/../lib/gcc/11/gcc/x86_64-pc-linux-gn
            🍺  /home/linuxbrew/.linuxbrew/Cellar/gcc/11.3.0_2: 2,194 files, 347.3MB
            ==> Running `brew cleanup gcc`...
            Disable this behaviour by setting HOMEBREW_NO_INSTALL_CLEANUP.
            Hide these hints with HOMEBREW_NO_ENV_HINTS (see `man brew`).

        -   carbon環境を構築

            ### Install bazelisk using Homebrew.
            ```            
            $ brew install bazelisk
            ==> Downloading https://ghcr.io/v2/homebrew/core/bazelisk/manifests/1.12.0
            ######################################################################## 100.0%
            ==> Downloading https://ghcr.io/v2/homebrew/core/bazelisk/blobs/sha256:10f980dadb7506495e909514ca621356553c8e138e33048d1
            ==> Downloading from https://pkg-containers.githubusercontent.com/ghcr1/blobs/sha256:10f980dadb7506495e909514ca621356553
            ######################################################################## 100.0%
            ==> Pouring bazelisk--1.12.0.x86_64_linux.bottle.tar.gz
            🍺  /home/linuxbrew/.linuxbrew/Cellar/bazelisk/1.12.0: 7 files, 4.9MB
            ==> Running `brew cleanup bazelisk`...
            Disable this behaviour by setting HOMEBREW_NO_INSTALL_CLEANUP.
            Hide these hints with HOMEBREW_NO_ENV_HINTS (see `man brew`).
            ```

            ### Install Clang/LLVM using Homebrew.
            -   Many Clang/LLVM releases aren't built with options we rely on.
            ```
            $ brew install llvm
            $ export PATH="$(brew --prefix llvm)/bin:${PATH}"
            ```
            ### Download Carbon's code.
            ```
            $ git clone https://github.com/carbon-language/carbon-lang
            ```

            ### Build and run the explorer.
            ```
            $ cd carbon-lang
            $ bazel run //explorer -- ./explorer/testdata/print/format_only.carbon
            2022/07/31 11:16:21 Downloading https://releases.bazel.build/5.1.1/release/bazel-5.1.1-linux-x86_64...
            Extracting Bazel installation...
            Starting local Bazel server and connecting to it...
            INFO: Invocation ID: 08a17816-441c-4fc7-a7bc-f9e871fa3ea8
            WARNING: Download from https://mirror.bazel.build/ftp.gnu.org/gnu/m4/m4-1.4.18.tar.xz failed: class java.io.FileNotFoundException GET returned 404 Not Found
            WARNING: Download from https://mirror.bazel.build/github.com/jmillikin/rules_m4/releases/download/v0.1/m4-gnulib-788db09a9f88abbef73c97e8d7291c40455336d8.tar.xz failed: class java.io.FileNotFoundException GET returned 404 Not Found
            WARNING: Download from https://mirror.bazel.build/ftp.gnu.org/gnu/bison/bison-3.3.2.tar.xz failed: class java.io.FileNotFoundException GET returned 404 Not Found
            WARNING: Download from https://mirror.bazel.build/github.com/jmillikin/rules_bison/releases/download/v0.1/bison-gnulib-788db09a9f88abbef73c97e8d7291c40455336d8.tar.xz failed: class java.io.FileNotFoundException GET returned 404 Not Found
            INFO: Analyzed target //explorer:explorer (67 packages loaded, 1555 targets configured).
            INFO: Found 1 target...
            ERROR: /home/taishow/.cache/bazel/_bazel_taishow/72d0ad9945d9497741a773f035acb5b0/external/llvm-project/llvm/BUILD.bazel:164:11: Compiling llvm/lib/Support/CRC.cpp failed: (Exit 1): clang++ failed: error executing command /home/linuxbrew/.linuxbrew/Cellar/llvm/14.0.6_1/bin/clang++ -no-canonical-prefixes -fcolor-diagnostics -Werror -Wall -Wextra -Wthread-safety -Wself-assign -Wimplicit-fallthrough ... (remaining 86 arguments skipped)

            Use --sandbox_debug to see verbose messages from the sandbox
            external/llvm-project/llvm/lib/Support/CRC.cpp:86:10: fatal error: 'zlib.h' file not found
            #include <zlib.h>
                    ^~~~~~~~
            1 error generated.
            Target //explorer:explorer failed to build
            Use --verbose_failures to see the command lines of failed build steps.
            INFO: Elapsed time: 241.429s, Critical Path: 7.36s
            INFO: 367 processes: 176 internal, 191 linux-sandbox.
            FAILED: Build did NOT complete successfully
            FAILED: Build did NOT complete successfully
            ```
