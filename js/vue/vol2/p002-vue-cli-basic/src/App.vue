<!--（1）-->
<template>
    あなたの名前：<input v-model="name"><!-- テキストボックス ...（1a）-->
    <div>→あなたは{{ name }}さん</div><!-- 名前の表示 ...（1b）-->
    <button v-on:click="onButtonClicked()">あいさつ</button> <!-- ボタン ...（1c）-->
</template>

<!--（2）-->
<script lang="ts">
import { defineComponent } from 'vue';
import { MyFirstTS } from './my-first-ts'; // MyFirstTSクラスをインポート ...（2a）

export default defineComponent({ // defineComponentはTypeScriptの型推論に必要 ...（2b）
  name: 'App',
  components: {
  },
  data() { // データ ...（2c）
    return {
      name: '吉川英一'
    }
  },
  methods: { // メソッド ..（2d）
    onButtonClicked() {
      // MyFirstTSクラスを利用してあいさつ文を作ってダイアログ表示 ...（2e）
      const myFirstTS = new MyFirstTS(this.name)
      alert(myFirstTS.getGreetText())
    }
  }
});
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
