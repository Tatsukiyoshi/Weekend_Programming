const style = {
    height: "50px",
    backgroundColor: "wheat",
    padding: "8px"
};

export const Child4 = () => {
    console.log("Child4レンダリング");

    return (
        <div style={style}>
            <p>Child4</p>
        </div>
    );
};
