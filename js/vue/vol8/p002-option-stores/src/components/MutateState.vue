<template>
  <div class="component">
    <!-- ボタン -->
    <button @click="onClickButtonIncrement">カウンターを1追加</button>
  </div>
</template>
<script setup lang="ts">
// ストアを取得
import { useCounterStore } from '../stores/counter'
const store = useCounterStore()
// カウンター追加ボタンの処理
function onClickButtonIncrement() {
  // ストアのincrementアクションを実行
  store.increment()
}
</script>
<style scoped>
.component {
  background-color: lightpink;
  padding: 15px;
}
</style>