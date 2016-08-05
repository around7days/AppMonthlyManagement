/**
 * 月報承認画面JS
 */
$(function() {

	/** form */
	var fmMain = $("#formMain");

	/** デフォルトURL */
	var defaultUrl = "/tran/report/approve/regist";

	/**
	 * 承認ボタン押下
	 */
	$("#approve").on("click", function() {
		if (!window.confirm("承認しますか？")) {
			return false;
		}
		var url = defaultUrl + "?approve";
		fmMain.attr("action", url);
		return true;
	});

	/**
	 * 否認ボタン押下
	 */
	$("#deny").on("click", function() {
		if (!window.confirm("否認しますか？")) {
			return false;
		}
		var url = defaultUrl + "?deny";
		fmMain.attr("action", url);
		return true;
	});

	/**
	 * 戻るボタン押下
	 */
	$("#back").on("click", function() {
		var url = defaultUrl + "?back";
		fmMain.attr("action", url);
		return true;
	});
});