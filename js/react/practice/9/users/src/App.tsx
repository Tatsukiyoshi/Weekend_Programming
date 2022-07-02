import React from 'react';
import logo from './logo.svg';
import './App.css';
import { useState } from "react";
import { useFetchUsers } from "./hooks/useFetchUsers";

function App() {
  // カスタムフックの使用
  // 関数を実行し返却値を分割代入で受け取る
  const { userList, isLoading, isError, onClickFetchUser } = useFetchUsers();
}

export default App;
