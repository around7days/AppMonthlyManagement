/**
 * 月報一括承認画面JS
 */
$(function() {

	/** form */
	var fmMain = $("#formMain");

	/** デフォルトURL */
	var defaultUrl = "/tran/reportapproveregistbulk";

	/**
	 * 一括承認ボタン押下
	 */
	$("#approveBulk").on("click", function() {
		var url = defaultUrl + "?approveBulk";
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