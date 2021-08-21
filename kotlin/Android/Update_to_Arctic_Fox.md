- Android Studio Arctic Fox 2020.3.1 (based IntelliJ 2020.3)
    - 環境刷新
        - Kotlln 1.5.21 <BR>
        Build.gradleでKotlinバージョンを変更
        - Gradle V7.0 <BR>
        Project Referenceで使用するGradleのバージョンを変更
            - Android Gradle Plugin Version: 7.0.1
            - Gradle Vercion: 7.0.2
        - JDK 11 <BR>
        Android Studioに含まれるJDKがJDK11に変更になり、同じJDKをGradle実行にも使用するため、Gradle SettingでAndroid Studioに含まれるJDKを使用するように変更する

        build.gradle(project)
        ```
        buildscript {
            ext.kotlin_version = '1.5.21'
            repositories {
                google()
                mavenCentral()
            }
            dependencies {
                classpath "com.android.tools.build:gradle:7.0.1"
                classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
            }
        }
        ```
    - 非互換として吸収すべき課題
        - SDKバージョン範囲の見直し <BR>
        ビルド時に下記メッセージが出るため、SDKバージョンを26以上にする
            * "Invoke-customs are only supported starting with Android O (--min-api 26)"
            * "Default interface methods are only supported starting with Android N (--min-api 24)
            * "Static interface methods are only supported starting with Android N (--min-api 24)
        - マニフェスト
            * アクティビティのエクスポート
              manifestでintent-filerを使っているため、下記を参照して設定。<BR>
            https://developer.android.com/guide/topics/manifest/activity-element#exported <BR>
            intent-filterを指定している場合には、android:exportedをtrueにする必要あり
            ```
            <activity android:name=".MainActivity" android:exported="true">
                <intent-filter>
                ...
                </intent-filter>
            </activity>
            ```
        - ビューバインディング <BR>
            Andorid 3.5までの実装を変更する <BR>
            https://developer.android.com/topic/libraries/view-binding?hl=ja
            *   ビューバインディングの使用を宣言する <BR>
            build.gradle(app)
            ```
            android {
                viewBinding {
                    enabled = true
                }
            }
            ```
            *   ビューバインディング使用により、不要になるkotlin-android-extensionsプラグインを削除する（削除すると、下記のようになる）
            ```
            plugins {
                id 'com.android.application'
                id 'kotlin-android'
            }
            ```

            * アクティビティの場合
                * アクティビティにバインディングクラスのインスタンス変数を追加する
                ```
                class MainActivity : AppCompatActivity() {
                    private lateinit var binding: ActivityMainBinding
                    ...
                }
                ```
                * インポートする名前空間を変更する（上記の変数を追加するとIDEからメッセージが出る）
                ```
                import kotlinx.android.synthetic.main.activity_main.*
                ```
                ```
                import com.example.helloandroid.databinding.ActivityMainBinding
                ```
                * 初期化時にバインディングクラスのインスタンス変数を初期化し、ルートビューへの参照を取得する
                ```
                override fun onCreate(savedInstanceState: Bundle?) {
                    super.onCreate(savedInstanceState)
                    binding = ActivityMainBinding.inflate(layoutInflater)
                    val view = binding.root
                    setContentView(view)
                    ...
                }
                ```
                * アクティビティ内の項目へのアクセスを変更する
                ```
                override fun onCreate(savedInstanceState: Bundle?) {
                    ...
                    tapHere.setOnClickListener {
                        textView.text = "ボタンがタップされました"
                    }
                }
                ```
                ↓
                ```
                override fun onCreate(savedInstanceState: Bundle?) {
                    ...
                    binding.tapHere.setOnClickListener {
                        binding.textView.text = "ボタンがタップされました"
                    }
                }
                ```
            * フラグメントの場合
                * フラグメントにバインディングクラスのインスタンス変数を追加する
                ```
                private var _binding: ResultProfileBinding? = null
                // This property is only valid between onCreateView and
                // onDestroyView.
                private val binding get() = _binding!!
                ```
                * フラグメントの初期化時にバインディングクラスのインスタンス変数を初期化し、ルートビューへの参照を取得する
                ```
                override fun onCreateView(
                    inflater: LayoutInflater,
                    container: ViewGroup?,
                    savedInstanceState: Bundle?
                ): View? {
                    _binding = ResultProfileBinding.inflate(inflater, container, false)
                    val view = binding.root
                    return view
                }
                ```
                * フラグメントの破棄時にバインディングクラスのインスタンス変数を解放する
                ```
                override fun onDestroyView() {
                    super.onDestroyView()
                    _binding = null
                }
                ```
                * フラグメント内の項目への参照を変更する
                ```
                name.text = viewModel.name
                button.setOnClickListener { viewModel.userClicked() }
                ```
                ↓
                ```
                binding.name.text = viewModel.name
                binding.button.setOnClickListener { viewModel.userClicked() }
                ```
            * フラグメントをアクティビティ内で機能させる <BR>
                https://developer.android.com/guide/fragments/fragmentmanager
                * フラグメント生成
                ```
                val fragment = TitleFragment()
                fragment.setTitle("フラグメント動物図鑑")
                ```
                * フラグメントマネージャーの取得
                ```
                val fragmentManeger = this.supportFragmentManager
                ```
                * トランザクション実行 <BR>
                下記例では、トランザクション開始～フラグメント追加～トランザクション終了（コミット）を一連のブロック(commitブロック)で実行する
                ```
                supportFragmentManager.commit {
                    replace(R.id.fragmentContainerView, fragment)
                    addToBackStack("name") // name can be null
                }
                ```
        - 共有プリファレンス <BR>
        https://github.com/android/user-interface-samples/blob/master/PreferencesKotlin/app/build.gradle
        - FragmentStatePagerAdapter <BR>
        https://developer.android.com/reference/androidx/fragment/app/FragmentStatePagerAdapter
        - SoundPool(Lollipopで非推奨) <BR>
        https://developer.android.com/reference/kotlin/android/media/SoundPool?hl=en
        - Handler <BR>
        https://developer.android.com/reference/kotlin/android/os/Handler?hl=en
