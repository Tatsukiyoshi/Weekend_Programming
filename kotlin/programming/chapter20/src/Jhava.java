// Jetbrainsのアノテーション
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

// Javaでクラスとメソッドを宣言する（リスト：20-1）
public class Jhava {
    // Java で int を宣言する（リスト：20-10）
    private int hitPoints = 52489112;
    // Java で挨拶を公開する（リスト：20-15）
    private String greeting = "BLARGH";

    // main メソッドを Java で定義する（リスト：20-18）
    public static void main(String[] args) {
        // Kotlin のトップレベル関数を Java から参照する（リスト：20-19）
        //System.out.println(HeroKt.makeProclamation());
        // Kotlin のトップレベル関数を 新しい名前で Java から参照する（リスト：20-21）
        System.out.println(Hero.makeProclamation());

        // Java で kotlin のフィールドに直接アクセスする（リスト：20-28）
        System.out.println("Spells:");
        Spellbook spellbook = new Spellbook();
        for (String spell : spellbook.spells) {
            System.out.println(spell);
        }

        // Java で static な値をアクセスする（リスト：20-30）
        System.out.println("Max spell count: " + Spellbook.MAX_SPELL_COUNT);

        // Java で static メソッドを呼び出す（リスト：20-33）
        Spellbook.getSpellbookGreeting();

        // Java で関数型を変数に格納する（リスト：20-41）
        Function1<String, Unit> translator = Hero.getTranslator();

        // Java で関数型を呼び出す（リスト：20-42）
        translator.invoke("TRUCE");
    }
    
    // 戻り値が null にならないことを表明する（リスト：20-9）
    @NotNull
    public String utterGreeting() {
        return greeting;
    }

    // Java で挨拶を公開する（リスト：20-15）
    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting){
        this.greeting = greeting;
    }

    // パラメータが１個のメソッドシグネチャ（リスト：20-23）
    public void offerFood() {
        Hero.handOverFood("pizza");
    }

    // Java で例外を送出する（リスト：20-34）
    public void extendHandInFriendship() throws Exception {
        throw new Exception();
    }

    // 戻り値が null になる可能性を示す（リスト：20-6）
    @Nullable
    // Java メソッドが null を返す（リスト：20-4）
    public String determineFriendshipLevel() {
        return null;
    }

    // ゲッターを宣言する（リスト：20-14）
    public int getHitPoints() {
        return hitPoints;
    }

    // Java で例外を送出する（リスト：20-38）
    public void apologize() {
        try {
            Hero.acceptApology();
        } catch (IOException e) {
            System.out.println("Caught!");
        }
    }
}
