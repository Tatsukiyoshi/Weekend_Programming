import tkinter as tk
import tkinter.messagebox as messagebox

# カゴの移動方向を設定する関数
def direction_control():
    cp = cage_position.get()        # カゴの現在位置
    cd = cage_direction.get()       # 現在の移動方向

    # より上の階のボタンが押されているかチェックする
    upper_buttons = False           # 押されていればTrueにする
    for p in range(cp + 1, TOP_FLOOR + 1):
        if cage_buttons[p].get() \
        or floor_up_buttons[p].get() \
        or floor_down_buttons[p].get():
            upper_buttons = True
            break

    # より下の階のボタンが押されているかチェックする
    lower_buttons = False           # 押されていればTrueにする
    for p in range(cp - 1, 0, -1):
        if cage_buttons[p].get() \
        or floor_up_buttons[p].get() \
        or floor_down_buttons[p].get():
            lower_buttons = True
            break

    # 以下は、決定表に合わせた処理
    # 現在の移動方向が"未定"の場合
    if cd == "未定":
        # より上の階とより下の階のボタンの両方が押されている場合（パターン1）
        if upper_buttons and lower_buttons:
            cage_direction.set("上昇")
        # より上の階のボタンだけが押されている場合（パターン2）
        elif upper_buttons and not lower_buttons:
            cage_direction.set("上昇")
        # より上の階のボタンだけが押されている場合（パターン3）
        elif not upper_buttons and lower_buttons:
            cage_direction.set("下降")
    # 現在の移動方向が"上昇"の場合
    elif cd == "上昇":
        # より上の階のボタンだけが押されている場合（パターン7）
        if not upper_buttons and lower_buttons:
            cage_direction.set("下降")
        # より上の階とより下の階のボタンの両方とも押されていない場合（パターン8）
        elif not upper_buttons and not lower_buttons:
            cage_direction.set("未定")
    # 現在の移動方向が"下降"の場合
    else:
        # より上の階のボタンだけが押されている場合（パターン10）
        if upper_buttons and not lower_buttons:
            cage_direction.set("上昇")
        # より上の階とより下の階のボタンの両方とも押されていない場合（パターン12）
        elif not upper_buttons and not lower_buttons:
            cage_direction.set("未定")

# 扉を開く関数
def door_control():
    door_open = False                   # 扉を開いたらTrueにする
    cp = cage_position.get()            # カゴの現在位置
    cd = cage_direction.get()           # 現在の移動方向
    fub = floor_up_buttons[cp].get()    # 現在位置の[↑]ボタンの選択状態
    fdb = floor_down_buttons[cp].get()  # 現在位置の[↓]ボタンの選択状態
    
    #　現在位置のカゴ内ボタンが押されている場合
    if cage_buttons[cp].get():
        door_open = True                # 扉を開く
        cage_buttons[cp].set(False)     # ボタンの選択を解除する

    # 以下は、決定表に合わせた処理
    # 現在位置の[↑]と[↓]ボタンの両方が押されている場合
    if fub and fdb:
        # 現在の移動方向が"未定"の場合（パターン1）
        if cd == "未定":
            door_open = True                    # 扉を開く
            floor_up_buttons[cp].set(False)     # ボタンの選択を解除する
            cage_direction.set("上昇")          # 移動方向を"上昇"に変更する
        # 現在の移動方向が"上昇"の場合（パターン2）
        elif cd == "上昇":
            door_open = True                    # 扉を開く
            floor_up_buttons[cp].set(False)     # ボタンの選択を解除する
        # 現在の移動方向が"下降"の場合（パターン3）
        else:
            door_open = True                    # 扉を開く
            floor_down_buttons[cp].set(False)   # ボタンの選択を解除する
    # 現在位置の[↑]ボタンだけが押されている場合
    elif fub and not fdb:
        # 現在の移動方向が"未定"の場合（パターン4）
        if cd == "未定":
            door_open = True                    # 扉を開く
            floor_up_buttons[cp].set(False)     # ボタンの選択を解除する
            cage_direction.set("上昇")          # 移動方向を"上昇"に変更する
        # 現在の移動方向が"上昇"の場合（パターン5）
        elif cd == "上昇":
            door_open = True                    # 扉を開く
            floor_up_buttons[cp].set(False)     # ボタンの選択を解除する
    # 現在位置の[↓]ボタンだけが押されている場合
    elif not fub and fdb:
        # 現在の移動方向が"未定"の場合（パターン7）
        if cd == "未定":
            door_open = True                    # 扉を開く
            floor_down_buttons[cp].set(False)   # ボタンの選択を解除する
            cage_direction.set("下降")          # 移動方向を"下降"に変更する
        # 現在の移動方向が"下降"の場合（パターン9）
        elif cd == "下降":
            door_open = True                    # 扉を開く
            floor_down_buttons[cp].set(False)   # ボタンの選択を解除する

    # 扉を開く
    if door_open:
        # 扉を開きました、というメッセージボックスを表示する
        messagebox.showinfo("エレベータ", "扉を開きました。")

    # 扉を開いたらTrueを返す
    return door_open

# カゴを移動する関数
def cage_control():
    cp = cage_position.get()            # カゴの現在位置
    cd = cage_direction.get()           # 現在の移動方向

    # 現在の移動方向が"上昇"で、かつ、現在位置＜最上階の場合
    if cd == "上昇" and cp < TOP_FLOOR:
        # カゴを1つ上に進める
        cage_position.set(cp + 1)
    # 現在の移動方向が"下降"で、かつ、現在位置＞最下階の場合
    elif cd == "下降" and cp > 1:
        # カゴを1つ下に進める
        cage_position.set(cp - 1)
    # カゴの移動を行えない場合
    else:
        # 行先ボタンを押してください、というメッセージボックスを表示する
        messagebox.showinfo("エレベータ", "行先ボタンを押してください。")

# 「次の動作」ボタンがクリックされたときに呼び出される関数
def next_motion():
    # カゴの移動方向を設定する
    direction_control()
    
    # 扉を開く
    if door_control():
        # 扉を開いたらカゴの移動は次の動作にする
        return

    # カゴを移動する
    cage_control()

# カゴの移動方向を示すボタンがクリックされたときに呼び出される関数
def change_direction():
    # 「未定」「上昇」「下降」を順番に切り替える
    cd = cage_direction.get()
    if cd == "未定":
        cage_direction.set("上昇")
    elif cd == "上昇":
        cage_direction.set("下降")
    else:
        cage_direction.set("未定")

# 以下はグローバル変数およびGUI
# 最上階を5Fとする
TOP_FLOOR = 5

# Tkのルートを作成する
root = tk.Tk()
root.title("エレベータ")

# 現在のカゴの位置
cage_position = tk.IntVar()
cage_position.set(1)

# カゴの動作（"未定"、"上昇"、"下降"）
cage_direction = tk.StringVar()
cage_direction.set("未定")

# カゴ内のボタンの選択状態
cage_buttons = []
for n in range(TOP_FLOOR + 1):
    bv = tk.BooleanVar()
    bv.set(False)
    cage_buttons.append(bv)

# 各階の[↑]ボタンの選択状態
floor_up_buttons = []
for n in range(TOP_FLOOR + 1):
    bv = tk.BooleanVar()
    bv.set(False)
    floor_up_buttons.append(bv)

# 各階の[↓]ボタンの選択状態
floor_down_buttons = []
for n in range(TOP_FLOOR + 1):
    bv = tk.BooleanVar()
    bv.set(False)
    floor_down_buttons.append(bv)

# ラベル付きフレームを作成する
flame1 = tk.LabelFrame(root, text="カゴの現在位置", labelanchor=tk.N)
flame1.grid(row=0, column=0, padx=5, pady=5)
flame2 = tk.LabelFrame(root, text="カゴ内のボタン", labelanchor=tk.N)
flame2.grid(row=0, column=1, padx=5, pady=5)
flame3 = tk.LabelFrame(root, text="各階のボタン", labelanchor=tk.N)
flame3.grid(row=0, column=2, padx=5, pady=5)

# カゴの現在位置を示すラジオボタンを作成する
cp_list = [("5F", 5, 0), 
           ("4F", 4, 1), 
           ("3F", 3, 2), 
           ("2F", 2, 3), 
           ("1F", 1, 4)]
for c_text, c_val, c_row in cp_list:
    rdo = tk.Radiobutton(flame1, text=c_text, value=c_val, 
    variable=cage_position, indicatoron=0, width=4, 
    font=("", "20", ""), bg="white", selectcolor="cyan")
    rdo.grid(row=c_row, column=0, padx=5, pady=5)

# カゴ内のボタンを表すチェックボタンを作成する
cb_list = [("5", 0), 
           ("4", 1), 
           ("3", 2), 
           ("2", 3), 
           ("1", 4)]                
for c_text, c_row in cb_list:
    chk = tk.Checkbutton(flame2, text=c_text, 
    variable=cage_buttons[int(c_text)], indicatoron=0, width=4, 
    font=("", "20", ""), bg="white", selectcolor="yellow")
    chk.grid(row=c_row, column=0, padx=5, pady=5)

# 各階のボタンを表すチェックボタンを作成する
fb_list = [("5", 0), 
           ("4", 1), 
           ("3", 2), 
           ("2", 3), 
           ("1", 4)]
for f_text, f_row in fb_list:
    # 上昇ボタン
    if f_text != "5":
        chk1 = tk.Checkbutton(flame3, text="↑", 
        variable=floor_up_buttons[int(f_text)], indicatoron=0, 
        width=4, 
        font=("", "20", ""), bg="white", selectcolor="yellow")
        chk1.grid(row=f_row, column=0, padx=5, pady=5)
    # 下降ボタン
    if f_text != "1":
        chk2 = tk.Checkbutton(flame3, text="↓", 
        variable=floor_down_buttons[int(f_text)], indicatoron=0, width=4, 
        font=("", "20", ""), bg="white", selectcolor="yellow")
        chk2.grid(row=f_row, column = 1, padx=5, pady=5)

# カゴの移動方向を示すボタンを作成する
btn_change = tk.Button(root, textvariable=cage_direction, command=change_direction)
btn_change.grid(row=1, column=0, padx=5, pady=5, 
sticky=tk.W + tk.E + tk.N + tk.S)

# 「次の動作」ボタンを作成する
btn_next = tk.Button(root, text="次の動作", command=next_motion)
btn_next.grid(row=1, column=1, padx=5, pady=5, columnspan=2, 
sticky=tk.W + tk.E + tk.N + tk.S)

# イベント待ちの無限ループ
root.mainloop()
