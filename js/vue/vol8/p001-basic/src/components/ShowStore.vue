<template>
  <div class="component">
    <!-- ストアの内容を表示 -->
    <div>State（count）：{{ store.count }}</div>
    <div>Getter（doubleCount）：{{ store.doubleCount }}</div>
  </div>
</template>
<script setup lang="ts">
import { useCounterStore } from '../stores/counter'

// ストアを取得
const store = useCounterStore()
</script>
<style scoped>
.component {
  background-color: lightblue;
  padding: 15px;
}
</style>
