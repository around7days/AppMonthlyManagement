package rms.test.junit.batch;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import rms.SpringBatchApplication;
import rms.batch.app.B001Batch;
import rms.common.base.BusinessException;
import rms.common.consts.MessageEnum;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBatchApplication.class)
public class B001BatchTest {

    @Autowired
    B001Batch b001;

    @Test
    public void 月報初期データ登録処理_失敗_未来日付エラー() throws Exception {
        String targetYm = "209912";
        List<String> args = new ArrayList<>();
        args.add(targetYm);

        try {
            b001.execute(args);
        } catch (BusinessException e) {
            assertThat(e.getErrorCode(), is(MessageEnum.error017.name()));
        }
    }

    @Test
    public void 月報初期データ登録処理_失敗_パラメータエラー() throws Exception {
        String targetYm = "201x";
        List<String> args = new ArrayList<>();
        args.add(targetYm);

        try {
            b001.execute(args);
        } catch (BusinessException e) {
            assertThat(e.getErrorCode(), is(MessageEnum.error016.name()));
        }
    }

    @Test
    public void 月報初期データ登録処理_成功_パラメータ指定あり() throws Exception {
        String targetYm = "201705";
        List<String> args = new ArrayList<>();
        args.add(targetYm);

        b001.execute(args);

        assertTrue(true);
    }

    @Test
    public void 月報初期データ登録処理_成功_パラメータ指定なし() throws Exception {
        List<String> args = new ArrayList<>();

        b001.execute(args);

        assertTrue(true);
    }

}