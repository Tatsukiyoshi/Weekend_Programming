import { UseService } from "./use.service";

export class AliasService extends UseService {
    override show() {
        return 'HogeHoge';
    }
}
