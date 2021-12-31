import Heading from './Heading.js';
import Button from './Button.js';
import {useState} from 'react';

function App() {
  const [count, setCount] = useState(0);
  const [color, setColor] = useState('#000000');

  const colors = ['#00ff00', '#ff0000', '#0000ff'];

  let handleClick = () => {
    setCount(count+1);
    setColor(colors[Math.floor(Math.random() * 3)]);
  }

  return (
    <main>
      <Heading count={count} />     
      <Button color={color} handleClick={handleClick} />
    </main>
  )
}

export default App;
