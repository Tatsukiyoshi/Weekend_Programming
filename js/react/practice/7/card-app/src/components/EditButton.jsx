const style = {
    width: "100px",
    padding: "6px",
    borderRadius: "8px"
};

export const EditButton = props => {
    const { isAdmin } = props;

    // isAdminがfalse(管理者でない)時にボタンを非活性にする
    return (
        <button style={style} disabled={!isAdmin}>
            編集
        </button>
    );
};

