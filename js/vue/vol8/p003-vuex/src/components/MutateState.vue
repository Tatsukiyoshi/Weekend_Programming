<template>
  <div class="component">
    <!-- ボタン -->
    <button @click="onClickButtonIncrement">カウンターを1追加</button>
  </div>
</template>
<script setup lang="ts">
// ストアを取得
import { useStore } from 'vuex'
const store = useStore()
// カウンター追加ボタンの処理
function onClickButtonIncrement() {
  // ストアのincrementアクションを実行
  store.dispatch('increment')
}
</script>
<style scoped>
.component {
  background-color: lightpink;
  padding: 15px;
}
</style>