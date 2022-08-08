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
  <!-- ボタンとイベントハンドラー ...（1）-->
  <div>
    <button v-on:click="onAddButtonClicked"> <!-- v-onでボタン押下時の処理を指定 ...（1a）-->
      追加
    </button>
    <button @click="onDelButtonClicked"> <!-- v-onの省略記法 ...（1b）-->
      削除
    </button>
  </div>
  <hr/>
  <!-- v-if、v-else-if、v-elseの記法 ...（2）-->
  <!-- phones配列の長さが0のとき -->
  <h1 v-if="phones.length == 0"></h1>
  <!-- phones配列の長さが1のとき -->
  <h1 v-else-if="phones.length == 1">電話の登録ありがとう</h1>
  <!-- phones配列の長さが2のとき -->
  <h1 v-else-if="phones.length == 2">2台持ちとはなかなか</h1>
  <!-- phones配列の長さがそれ以外（3以上）のとき -->
  <h1 v-else>3台以上持っているの！？</h1>
  <table>
    <thead>
      <tr>
        <th>番号</th>
        <th>会社</th>
        <th>機種</th>
        <th>重量</th>
        <th>URL</th>
      </tr>
    </thead>
    <tbody>
      <!-- v-forの記法 ...（3）-->
      <tr v-for="phone in phones" v-bind:key="phone.no">
        <td>{{ phone.no }}</td>
        <td>{{ phone.company }}</td>
        <td>{{ phone.name }}</td>
        <td>{{ phone.weight }} </td>
        <td>{{ phone.url }} </td>
      </tr>
    </tbody>
  </table>
</template>

<script lang="ts">
import { defineComponent } from "vue"
// TypeScriptのインタフェース ...（1）
interface Phone {
  no: number
  company: string
  name: string
  url: string
  weight: number
}
export default defineComponent({
  // データ ...（2）
  data() {
    return {
      phones: [] as Array<Phone>, // Phoneインタフェース配列を型指定 ...（2a）
      no: 1,
      company: 'Apple',
      name: 'iPhone 13',
      url:'https://www.apple.com/' as string,
      weight: 173 as number
    }
  },
  methods: {
    onAddButtonClicked() {  // 追加ボタン押下時の処理 ...（3）
      // Phoneインタフェースに適合したオブジェクトが設定できる
      this.phones.push({
        no: this.no,
        company: this.company,
        name: this.name,
        url: this.url,
        weight: this.weight
      })
    },
    onDelButtonClicked() {  // 削除ボタン押下時の処理 ...（4）
      this.phones.pop()     // 最終要素を削除
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
