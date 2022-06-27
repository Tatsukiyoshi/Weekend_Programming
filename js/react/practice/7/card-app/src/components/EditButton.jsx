// "react"からuseContextをimport
import { useContext } from "react";

// 作成したcontextをimport
import { AdminFlagContext } from "./providers/AdminFlagProvider";

const style = {
    width: "100px",
    padding: "6px",
    borderRadius: "8px"
};

export const EditButton = props => {
    // Context内のisAdminを取得
    const { isAdmin } = useContext(AdminFlagContext);

    // isAdminがfalse(管理者でない)時にボタンを非活性にする
    return (
        <button style={style} disabled={!isAdmin}>
            編集
        </button>
    );
};
