- Android Studio Arctic Fox 2020.3.1 (based IntelliJ 2020.3) <font color=red><strong>Wrote first at 2021.8.20</strong></font>
    - 環境刷新
        - Kotlln 1.5.21 <BR>
        Build.gradleでKotlinバージョンを変更
        - Gradle V7.0 <BR>
        Project Referenceで使用するGradleのバージョンを変更
            - Android Gradle Plugin Version: 7.0.1 <font color=red><strong>Update at 2021.8.20</strong></font>
            - Gradle Vercion: 7.0.2
        - JDK 11 <BR>
        Android Studioに含まれるJDKがJDK11に変更になり、同じJDKをGradle実行にも使用するため、Gradle SettingでAndroid Studioに含まれるJDKを使用するように変更する

        build.gradle(project) <font color=red><strong>Update at 2021.8.20</strong></font>
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
        - SDKバージョン範囲の見直し <font color=red><strong>Update at 2021.8.20</strong></font><BR>
        ビルド時に下記メッセージが出るため、SDKバージョンを26以上にする
            * "Invoke-customs are only supported starting with Android O (--min-api 26)"
            * "Default interface methods are only supported starting with Android N (--min-api 24)
            * "Static interface methods are only supported starting with Android N (--min-api 24)
        - マニフェスト <font color=red><strong>Update at 2021.8.20</strong></font>
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
                ): View {
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
            * フラグメントをアクティビティ内で機能させる <font color=red><strong>Update at 2021.8.21</strong></font><BR>
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
        - 共有プリファレンス
            - build.gradle(app)に以下を追加する        
            ```
            dependencies {
                ...
                implemetation 'androidx.preference:preference-ktx:1.1.0'
                ...
            }
            ```
        - FragmentStatePagerAdapterの置換 <font color=red><strong>Update at 2021.8.22</strong></font><BR>
            - アダプタの継承クラスのコンストラクタの継承元をFragmentStateAdapterに置き換える <BR>
            https://developer.android.com/reference/androidx/fragment/app/FragmentStatePagerAdapter
                ```
                class MyAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm){
                    ...
                    override fun getCount(): Int {
                        ...
                    }
                }
                ```
                https://developer.android.com/reference/androidx/viewpager2/adapter/FragmentStateAdapter
                ```
                class MyAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa){
                    ...
                    override fun getItemCount(): Int {
                        ...
                    }
                }
                ```
            - アクティビティでのアダプタへのアクセスを変更する
                ```
                binding.pager.adapter = MyAdapter(supportFragmentManager)
                ```
                ↓
                ```
                binding.pager.adapter = MyAdapter(this)
                ```
        - タイマ処理におけるハンドラ周りを見直す <font color=red><strong>Update at 2021.8.22</strong></font><BR> 
        https://developer.android.com/reference/kotlin/android/os/Handler?hl=en
            - ハンドラ生成の見直し
                ```
                var handler = Handler()
                ```
                ↓
                ```
                Looper.prepare()
                val handler = Looper.myLooper()?.let { Handler(it, null) }
                ```
            - ハンドラ利用の見直し（セーフアクセス修飾子）
                ```
                timer(period = 5000){
                    handler.post {
                        ...
                    }
                }
                ```
                ↓
                ```
                timer(period = 5000){
                    handler?.post {
                        ...
                    }
                }
                ```
        - フラグメント作成後の処理手続きの変更 <font color=red><strong>Update at 2021.8.22</strong></font><BR>
        onActivityCreatedメソッドでの実行は非推奨となったため、フラグメントのビューをタッチするコードは、onActivityCreatedメソッドの実行直前に呼び出されるonViewCreatedメソッドでの実行に変更。その他の初期化コードは onCreate() 内での実行に変更。
            ```
            override fun onActivityCreated(...){
                ...
            }
            ```
            ↓
            ```
            override fun onViewCreated(...){
                ...
            }
            ```
        - SoundPool(Lollipopで非推奨) <BR>
        https://developer.android.com/reference/kotlin/android/media/SoundPool?hl=en
