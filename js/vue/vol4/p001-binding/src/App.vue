<template>
  <!-- v-modelでフォーム内容と変数を紐づけ ...（1）-->
  <!-- 数値型を指定 ...（1a）-->
  <div>番号：<input v-model.number="no" /></div>
  <div>会社：<input v-model="company" /></div>
  <div>機種：<input v-model="name" /></div>
  <!-- 数値型を指定 ...（1b）-->
  <div>重量：<input v-model.number="weight" /></div>
  <div>URL：<input v-model="url" /></div>
  <hr>
  <!-- データの反映 ...（2）-->
  <div>
    <!-- 変数を参照 ...（2a）-->
    【No.{{ no }}】
    <!-- 算出プロパティを参照 ...（2b）-->
    {{ fullName }}
  </div>
  <div>
    <!-- メソッドの実行結果を参照 ...（2c）-->
    {{ getWeightText(weight) }}
  </div>
  <div>
    Webページ：
    <!-- url変数をhrefに反映 ...（2d）-->
    <a v-bind:href="url" target="_blank">
    <!--
    「:href」は「v-bind:href」の省略記法 ...（2e）
    <a :href="url" target="_blank">
    -->
      {{ url }}
    </a>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue"

// コンポーネント処理内容の記述 ...（1）
export default defineComponent({
  // データ ...（2）
  data() {
    return {
      no: 1,
      company: 'Apple',
      name: 'iPhone 13',
      // 明示的にstringを指定 ...（2a）
      url:'https://www.apple.com/' as string,
      // 明示的にnumberを指定 ...（2b）
      weight: 173 as number
    }
  },
  // 算出プロパティ ...（3）
  computed: {
    fullName(): string {
      return `${this.name} (${this.company})`
    },
  },
  // メソッド ...（4）
  methods: {
    getWeightText(weight: number): string {
      // weightはnumber型なのでtoFixedメソッドが利用できる ...（4a）
      return `重量：${weight.toFixed(1)} g`
    }
  }
})
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
