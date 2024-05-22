<template>
  <div class="component">
    <button @click="onClickFetchButton">JSONデータを取得</button>
  </div>
</template>
<script setup lang="ts">
// ストアを取得
import { usePhoneStore } from '@/stores/phone'
const store = usePhoneStore()

// JSONデータを取得ボタンの処理
async function onClickFetchButton() {
  // 非同期アクションを実行
  await store.fetchDataAsync()
}
</script>
<style scoped>
.component {
  background-color: lightgrey;
  padding: 15px;
}
</style>