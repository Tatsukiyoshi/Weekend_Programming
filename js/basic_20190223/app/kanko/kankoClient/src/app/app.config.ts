export const RETRY_INTERVAL =  100*1000;
export const SYNC_INTERVAL =  3*60*1000;
export const MAX_FAVORITE =  50;
export const USER_ID="user01";

let baseUrl = "https://localhost/db";
export const REMOTEDB_URL= baseUrl+"/kanko-info";
export const FAVORITE_URL= baseUrl+"/kanko-favorite";

export const AREA_FORM =  [
  { code: "0", name: "全国"},
  { code: "1", name: "北海道"},
  { code: "2", name: "東北"},
  { code: "3", name: "関東"},
  { code: "4", name: "中部"},
  { code: "5", name: "関西"},
  { code: "6", name: "中国"},
  { code: "7", name: "四国"},
  { code: "8", name: "九州・沖縄"}
];

export const AREA_MAP :{[key:string]:string}=  {
  "0": "全国",
  "1": "北海道",
  "2": "東北",
  "3": "関東",
  "4": "中部",
  "5": "関西",
  "6": "中国",
  "7": "四国",
  "8": "九州・沖縄"
};

export const GENRE_FORM = [
  {category: "自然景観",
    genre: [
      {code: "101", name: "山岳", checked: "false"},
      {code: "102", name: "高原", checked: "false"},
      {code: "103", name: "湖沼", checked: "false"},
      {code: "104", name: "河川景観", checked: "false"},
      {code: "105", name: "海岸景観", checked: "false"}
    ]
  },
  {
    category: "施設景観",
    genre: [
      {code: "201", name: "町並み", checked: "false"},
      {code: "202", name: "郷土景観", checked: "false"},
      {code: "203", name: "展望施設", checked: "false"}
    ]
  },
  {
    category: "公園・庭園",
    genre: [
      {code: "301", name: "公園", checked: "false"},
      {code: "302", name: "庭園", checked: "false"}
    ]
  },
  {
    category: "動・植物",
    genre: [
      {code: "401", name: "動物", checked: "false"},
      {code: "402", name: "植物", checked: "false"}
    ]
  }];

export const GENRE_MAP:{[key:string]:string} = {
  "101": "山岳",
  "102": "高原",
  "103": "湖沼",
  "104": "河川景観",
  "105": "海岸景観",
  "201": "町並み",
  "202": "郷土景観",
  "203": "展望施設",
  "301": "公園",
  "302": "庭園",
  "401": "動物",
  "402": "植物"
};
