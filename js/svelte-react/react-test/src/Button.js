function Button({ color, handleClick }) {
    const styles = {
        backgroundColor: color,
        color: '#ffffff'
    }
    return (
        <button style={styles}  onClick={handleClick}>
            Click me!
        </button>
    )
}

export default Button;
  