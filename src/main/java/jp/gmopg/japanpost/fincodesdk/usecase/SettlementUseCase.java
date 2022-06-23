package jp.gmopg.japanpost.fincodesdk.usecase;

import jp.gmopg.japanpost.fincodesdk.Repository.FincodeSettlementRepository;
import jp.gmopg.japanpost.fincodesdk.api.FincodeCallback;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeErrorResponse;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeSettlementRequest;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeSettlementResponse;

/**
 * Created by m.ohkawa on 2022/06/23.
 */
public class SettlementUseCase extends BaseUseCase {

    public void settlement(String orderId, FincodeSettlementRequest request) {

        FincodeSettlementRepository.getInstance().settlement(getHeader(), orderId, request, new FincodeCallback<FincodeSettlementResponse>() {
            @Override
            public void onResponse(FincodeSettlementResponse response) {
                //TODO テストアプリ側に決済完了を通知する処理
            }

            @Override
            public void onFailure(FincodeErrorResponse errorInfo) {
                // do nothing
            }
        });
    }
}
