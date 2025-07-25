このプロジェクトはエンジニアがどのようにエラー解決をしていくのかを観察するために故意にエラーを埋め込んだアプリである。
そのため、条件に従って以下のエラーを埋め込んだアプリを開発してください。

## アプリに埋め込むエラー一覧
Android固有ではない
- null参照
- 分岐条件がおかしい
- UIスレッドで重い処理をしているのでUIの操作ができなくなる
  Android固有
- INTERNETパーミッションがない
- UIスレッド以外からToast表示でエラー
- やたら重いリスト表示
- 自作したdata classをrememberSavableで保存しようとしているが、Saverがないのでエラー

## 条件
アプリには以下の画面がある。また、説明に書いているエラーをそれぞれの画面で埋め込んでください
- カウンター画面
  - カウンターにはカウントアップボタンとカウントダウンボタン、5秒後にカウントアップするボタンがある
    - 5秒後にカントアップするボタンで UIスレッドで重い処理をしているのでUIの操作ができなくなる　状態にして
  - カウントが0より小さくなることはない仕様
    - 条件分岐が間違っているのでカウントが0より小さくなってしまう状態を作って
  
- 投稿一覧を表示する画面（リストアイテムには投稿者のアイコン、名前、投稿内容などの情報が含まれる）
  -　https://jsonplaceholder.typicode.com/posts このAPIから情報を取得して
    - AndroidManifestにINTERNETパーミッションを追加していないのでエラーがでる状態にして   
  - 投稿者のアイコンはAPIから取得できないので適当な画像を利用して
    - 投稿をタップしたタイミングでToastを表示するがUIスレッド以外から実行してエラーがでる状態にして
- 永続化機能はないTodoリスト画面
  - インメモリリポジトリからサンプルデータを読み込む仕様だがその際にnull参照でエラーが出るようにする
- プロフィール画面
  - rememberSaverableで保存しようとするがSaverを作っていないのでエラーが出る状態にして

## 作業の進め方
1. まず、エラーが出ない正常に利用できるアプリを開発する
2. 適切な粒度でコミットを作成する
3. 新しくブランチを作成して上記の問題を埋め込んだ状態にしてください
4. 適切な粒度でコミットを作成する