package jp.gmopg.japanpost.fincodesdk.common;

/**
 * Created by a.nakajima on 2022/05/19.
 */
public interface ComponentImpl {

    // 必須か否か
    boolean required = true;

    // バリデーション チェック
    boolean validate();

    // バリデーション 表示クリア
    void clear();

    /// 見出しの表示・非表示
    void headingHidden(boolean value);

    // 活性・非活性
    void enabled(boolean value);
}
