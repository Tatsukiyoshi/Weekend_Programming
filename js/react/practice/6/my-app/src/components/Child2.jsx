const style = {
    height: "50px",
    backgroundColor: "lightgray"
};

export const Child2 = () => {
    console.log("Child2レンダリング");

    return (
        <div style={style}>
            <p>Child2</p>
        </div>
    );
};
