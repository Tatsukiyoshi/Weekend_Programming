<template>
  <div class="component">
    <div>機能：<input v-model="inputFeature">
      <button @click="onClickButtonAddFeature">追加</button>
      <button @click="onClickButtonDelFeature">削除</button>
    </div>
  </div>
</template>
<script setup lang="ts">
import { ref } from 'vue'
// ストアを取得
import { usePhoneStore } from '../stores/phone'
const store = usePhoneStore()
// テキストボックスの入力値を格納する変数
const inputFeature = ref('')
// 追加ボタンの処理
function onClickButtonAddFeature() {
  store.features.push(inputFeature.value)
  inputFeature.value = ''
}
// 削除ボタンの処理
function onClickButtonDelFeature() {
  store.features.pop()
  inputFeature.value = ''
}
</script>
<style scoped>
.component {
  background-color: lightyellow;
  padding: 15px;
}
input, button {
  margin-left: 8px;
}
</style>