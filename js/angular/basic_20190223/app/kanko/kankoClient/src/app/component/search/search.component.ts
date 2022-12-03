import {Component, OnDestroy, OnInit, ViewChild} from "@angular/core";
import {Router} from "@angular/router";
import {FormControl, FormGroup} from "@angular/forms";
import {MatStepperModule} from "@angular/material/stepper";
import {ScrollService} from "../../service/scroll.service";
import {StateService} from "../../service/state.service";
import {DataService} from "../../service/data.service";
import {AREA_FORM, AREA_MAP, GENRE_FORM, GENRE_MAP} from "../../app.config";
import {Catch} from '../../class/log.class';
@Component({
  selector: "app-search",
  templateUrl: "./search.component.html",
  styleUrls: ["./search.component.css"]
})
export class SearchComponent implements OnInit, OnDestroy {
  @ViewChild("mystepper") stepper: MatStepperModule;

  AREA_FORM = AREA_FORM;
  GENRE_FORM = GENRE_FORM;
  AREA_MAP = AREA_MAP;
  GENRE_MAP = GENRE_MAP;

  checkBoxGroup: FormGroup;
  selectedAreaName;
  selectedGenreName;
  areas;
  listPrefetchPromise;

  constructor(
    public router: Router,
    public scrollService: ScrollService,
    public stateService: StateService,
    public dataService: DataService,
  ) {
  }

  ngOnInit() {
    //ジャンル選択チェックボックス初期化
    this.initCheckBox();
  }

  initCheckBox() {
    // フォームグループを生成
    this.checkBoxGroup = new FormGroup({});

    //ジャンルごとにフォームコントロールを生成してフォームグループに登録
    Object.keys(this.GENRE_MAP).forEach(code => {
      this.checkBoxGroup.addControl(code, new FormControl(false));
    });
    //stateの値を反映
    this.stateService.state.genres.forEach(code => {
      this.checkBoxGroup.patchValue({[code]: true});
    });

    /*
    if (this.stateService.state.areas.length
      && this.stateService.state.genres.length) {
      this.stepper.selectedIndex = 1;
    }
    */

    // 選択の変更検知関数を登録
    this.checkBoxGroup.valueChanges.subscribe(v => this.update());

    this.update();
  }

  //エリアの選択をstateへ反映
  setArea(code: string) {
    //全国を選択
    if (code === "0") {
      this.stateService.state.areas = Object.keys(this.AREA_MAP).slice(1);
    } else {
      this.stateService.state.areas = [code];
    }
    this.update();
  }

  //ジャンルの選択をstateへ反映
  setGenre() {
    let values = this.checkBoxGroup.value;
    let selectedCode = Object.keys(values).filter(key => values[key]);
    this.stateService.state.genres = selectedCode || [];
  }

  //表示更新
  update() {
    //エリア選択表示更新
    if (this.stateService.state.areas.length > 1) {
      this.selectedAreaName = "全国";
    } else {
      this.selectedAreaName = this.AREA_MAP[this.stateService.state.areas[0]];
    }

//ジャンル選択表示更新
    let selectName="";
    let selectedCode = [];
    Object.keys(this.checkBoxGroup.value).forEach(code => {
      if (this.checkBoxGroup.value[code]) {
        selectName += this.GENRE_MAP[code] + ", ";
        selectedCode.push(code);
      }
    });
    selectName=selectName&&selectName.trim().replace(/,$/,"");
    this.selectedGenreName =selectName;

    this.stateService.state.genres = selectedCode;

    //検索結果件数表示更新
    let keys = [];
    this.stateService.state.areas.forEach(area => {
      selectedCode.forEach(genre => {
        keys.push(area + genre);
      });
    });
    this.stateService.state.selectedKeys = keys;
    if (keys.length > 0) {
      this.dataService.countDoc(keys);
    } else {
      this.stateService.docCount=null;
    }
  }

  selectAllGenre(isSelected: boolean) {
    let value = this.checkBoxGroup.value;
    Object.keys(value).forEach(key => {
      value[key] = isSelected;
    });
    this.checkBoxGroup.setValue(value);
  }

  //検索結果データの事前ロード
  // async docLoad() {
  //   await this.scrollService.setBuffer();
  // }

  //検索結果画面へ遷移
  async showData() {
    // this.stateService.state.listMode = LIST_MODE.SEARCH;
       this.router.navigate(["/list"]);
  }

  //ウイザードのステップ変更時の処理
  async onChangeStep(event) {
      this.update();
      if (event.selectedIndex === 2) {
      if(!this.stateService.state.setting.prefetch.value)return;
    await this.scrollService.prefetch();
      }

  }

  ngOnDestroy() {
    // this.subscription.unsubscribe();
    // this.setGenre();
  }

}


