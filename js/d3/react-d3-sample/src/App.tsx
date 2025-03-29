import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import LinePlot from './LintPlot'

function App() {
  const [count, setCount] = useState(0)
  const data = [1, 3, 2, 5, 4, 7, 6, 10, 8, 9]
  const width = 640
  const height = 320
  const marginTop = 20
  const marginRight = 20
  const marginBottom = 20
  const marginLeft = 20

  return (
    <>
      <div>
        <a href="https://vite.dev" target="_blank">
          <img src={viteLogo} className="logo" alt="Vite logo" />
        </a>
        <a href="https://react.dev" target="_blank">
          <img src={reactLogo} className="logo react" alt="React logo" />
        </a>
      </div>
      <h1>Vite + React</h1>
      <div className="card">
        <button onClick={() => setCount((count) => count + 1)}>
          count is {count}
        </button>
        <p>
          Edit <code>src/App.tsx</code> and save to test HMR
        </p>
      </div>
      <LinePlot data={data} width={width} height={height}
        marginTop={marginTop} marginRight={marginRight} marginBottom={marginBottom} marginLeft={marginLeft}>
      </LinePlot>
      <p className="read-the-docs">
        Click on the Vite and React logos to learn more
      </p>
    </>
  )
}

export default App
