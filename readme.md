# Dino Game - Chrome 공룡 게임

이 프로젝트는 Chrome 공룡 게임을 기반으로 제작한 웹 게임입니다.  
회원가입, 로그인, 점수 저장 기능이 포함되어 있으며 Docker를 이용해 실행 가능합니다.

---

## 빠른 시작을 위한 시스템 요구사항

- **Docker Desktop** (컨테이너 실행)
  - [Windows용 설치 안내](https://docs.docker.com/desktop/setup/install/windows-install/)
  - [macOS용 설치 안내](https://docs.docker.com/desktop/setup/install/mac-install/)
- **Git** (GitHub 저장소 클론)
  - [Git 다운로드](https://git-scm.com/downloads)

> Docker 설치 후, **Docker가 실행 중인지 확인**하세요.  
> Git 설치 후, 터미널에서 `git --version` 명령어로 정상 설치 여부를 확인할 수 있습니다.

---

## Windows 사용자를 위한 배포 방법

1. `start-dino-game.bat` 파일을 실행합니다.
2. 자동으로 아래 작업이 진행됩니다.
   - GitHub 저장소 클론
   - Docker 이미지 빌드 및 컨테이너 실행
3. 실행 완료 후 아래 메시지가 표시됩니다.
```Text
[3/4] 서버가 실행 중입니다.
종료하려면 "exit"을 입력하세요.
```
4. 서버를 계속 켜두면 서비스가 유지됩니다.
5. 웹 브라우저에서 [http://localhost](http://localhost)로 접속하면 게임을 플레이할 수 있습니다.
6. 터미널에 `exit`을 입력하면 컨테이너가 종료됩니다.

---

## macOS / Linux 사용자를 위한 배포 방법

1. 터미널을 실행합니다.
2. 아래 명령어를 차례로 입력합니다.
```Terminal
chmod +x start-dino-game.sh
./start-dino-game.sh
```
3. 자동으로 아래 작업이 진행됩니다.
- GitHub 저장소 클론
- Docker 이미지 빌드 및 컨테이너 실행
4. 실행 완료 후 아래 메시지가 표시됩니다.
```Text
[3/4] 서버가 실행 중입니다. 종료하려면 'exit'을 입력하세요.
```
5. 서버를 계속 켜두면 서비스가 유지됩니다.
6. 웹 브라우저에서 [http://localhost](http://localhost)로 접속하면 게임을 플레이할 수 있습니다.
7. 터미널에 `exit`을 입력하면 컨테이너가 종료됩니다.

---

## 게임 관련 정보

- 회원가입 후 로그인을 하면 게임 플레이가 가능합니다.
- 점수가 100점씩 쌓일 때마다 속도가 빨라지고, 낮과 밤이 전환됩니다.
- 점수판에서 점수와 플레이 시간을 확인할 수 있습니다.