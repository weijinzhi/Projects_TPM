/**
* 模块名：easyui方法修改
* 程序名: easyui.fix.js
**/
var easyuifix = {};

/** 
 * for easyloader.js
 * add after row 13 usage: easyuifix.addLoadModules(_1);
 */
easyuifix.easyloader_addLoadModules = function (modules) {
    $.extend(modules, {
        juidatepick: {
            js: rootPath+"/content/js/jquery-plugin/jquery-ui/js/jquery-ui-datepick.min.js",
            css: rootPath+"/content/js/jquery-plugin/jquery-ui/css/jquery-ui.css"
        },
        daterange: {
            js: rootPath+"/content/js/jquery-plugin/daterange/jquery.daterange.js",
            css: rootPath+"/content/js/jquery-plugin/daterange/jquery.daterange.css",
            dependencies: ["juidatepick"]
        },
        lookup: {
            js: rootPath+"/content/js/jquery-plugin/lookup/jquery.lookup.js",
            dependencies: ["combo"]
        },
        autocomplete: {
            js: rootPath+"/content/js/jquery-plugin/autocomplete/jquery.autocomplete.js",
            dependencies: ["combo"]
        }
    });
};

/** 
 *  for easyloader.js
 * add after row 181 usage: easyuifix.easyloader_setting(easyloader, src);
 */
easyuifix.easyloader_setting = function (easyloader,src) {
    easyloader.theme = "default";
    easyloader.locale = "zh_CN";
};

/**
 * for jquery.parser.js
 * add after row 89 usage: easyuifix.parser_addplugins($.parser.plugins);
 */
easyuifix.parser_addplugins = function (plugins) {
    var arr = ["daterange", "lookup", "autocomplete"];
    for (var i in arr) 
        plugins.push(arr[i]);
};

/** 
 * for jquery.tabs.js
 * add after row 415 usage: easyuifix.tabs_showtabonselect(_5d);
 */
easyuifix.tabs_showtabonselect =function(tab){
    tab.show();    //打开时其它页签先隐藏,,提升用户体验，点击时再显示
}

/**
 * for easyui-lang-zh_CN.js
 * add last row: easyuifix.lang_zh_CN();
 */
easyuifix.lang_zh_CN = function () {
    if ($.fn.lookup) {
        $.fn.lookup.defaults.missingMessage = '该输入项为必输项';
    }
};

/**
 * for jquery.datagrid.js
 * add after row 1137 usage: easyuifix.datagrid_beforeDestroyEditor(_10a, _10b, row);
 * for jquery.easyui.min.js
 * add after row 7622 usage: easyuifix.datagrid_beforeDestroyEditor(_530, _531, row);
 */
easyuifix.datagrid_beforeDestroyEditor = function (jq, rowIndex, row) {
    var opts = $.data(jq, "datagrid").options;
    if (opts.OnBeforeDestroyEditor) {
        var editors = {}, list = $(jq).datagrid('getEditors', rowIndex) || [];
        $.each(list, function () { editors[this.field] = this; });
        opts.OnBeforeDestroyEditor(editors, row, rowIndex, jq);
    }
};

/**
 * for jquery.datagrid.js 
 * add after row 1101 usage: easyuifix.datagrid_afterCreateEditor(_104, _105, row);
 * for jquery.easyui.min.js
 * add after row 7586 usage: easyuifix.datagrid_afterCreateEditor(_52a, _52b, row);
 */
easyuifix.datagrid_afterCreateEditor = function (jq, rowIndex, row) {
    var opts = $.data(jq, "datagrid").options;
    if (opts.OnAfterCreateEditor) {
        var editors = {}, list = $(jq).datagrid('getEditors', rowIndex) || [];
        $.each(list, function () { editors[this.field] = this; });
        opts.OnAfterCreateEditor(editors, row, rowIndex, jq);
    }
};

/**
 * for jquery.combo.js to convert disable to readonly
 * add after row 210 usage: easyuifix.combo_disableToReadonly(_32, _33);
 */
easyuifix.combo_disableToReadonly = function (jq, b) {
    var options = $.data(jq, "combo").options;
    var combo = $.data(jq, "combo").combo;
    if (b) {
        options.disabled = true;
        $(jq).attr("readonly", true);
        combo.find(".combo-value").attr("readonly", true).addClass("readonly");
        combo.find(".combo-text").attr("readonly", true).addClass("readonly");
    } else {
        options.disabled = false;
        $(jq).removeAttr("readonly");
        combo.find(".combo-value").removeAttr("readonly").removeClass("readonly");
        combo.find(".combo-text").removeAttr("readonly").removeClass("readonly");
    }
};

/**
 * for jquery.combobox.js to showblank
 * add after row 138 usage: easyuifix.combobox_showblank(_30, _2e);
 */
easyuifix.combobox_showblank = function (combobox, b) {
	if (combobox.showblank) {
    	b.unshift(combobox.blankdefault);
	}
}

/**
 * for jquery.combobox.js to showblank
 * add after row 350 usage: easyuifix.combobox_defaultblank();
 */
easyuifix.combobox_defaultblank = function () {
	$.fn.combobox.defaults = $.extend($.fn.combobox.defaults, {
		showblank: false,
    	blankdefault: { value: '', text: '== 请选择 ==' }
	});	
}

/**
 * for datagrid.js
 * add after row 2065 usage: if (easyuifix) easyuifix.datagrid_editor_extend();
 * use such as: using("lookup", easyuifix.datagrid_editor_extend);
 */
easyuifix.datagrid_editor_extend = function () {
    if ($.fn.datagrid) {
        if ($.fn.numberspinner) {
            $.extend($.fn.datagrid.defaults.editors, {
                numberspinner: {
                    init: function (container, options) {
                        var input = $('<input type="text">').appendTo(container);
                        return input.numberspinner(options);
                    },
                    destroy: function (target) {
                        $(target).numberspinner('destroy');
                    },
                    getValue: function (target) {
                        return $(target).numberspinner('getValue');
                    },
                    setValue: function (target, value) {
                        $(target).numberspinner('setValue', value);
                    },
                    resize: function (target, width) {
                        $(target).numberspinner('resize', width);
                    }
                }
            });
        }

        if ($.fn.autocomplete) {
            $.extend($.fn.datagrid.defaults.editors, {
                autocomplete: {
                    init: function (container, options) {
                        var input = $('<input type="text" class="z-text datagrid-editable-input">').appendTo(container);
                        return input.autocomplete(options);
                    },
                    destroy: function (target) {
                        $(target).autocomplete('destroy');
                    },
                    getValue: function (target) {
                        return $(target).val();
                    },
                    setValue: function (target, value) {
                        $(target).val(value);
                    },
                    resize: function (target, width) {
                        $(target).width(width);
                    }
                }
            });
        }

        if ($.fn.lookup) {
            $.extend($.fn.datagrid.defaults.editors, {
                lookup: {
                    init: function (container, options) {
                        var input = $('<input type="text" class="z-text datagrid-editable-input">').appendTo(container);
                        return input.lookup(options);
                    },
                    destroy: function (target) {
                        $(target).lookup('destroy');
                    },
                    getValue: function (target) {
                        return $(target).lookup('getValue');
                    },
                    setValue: function (target, value) {
                        $(target).lookup('setValue', value);
                    },
                    resize: function (target, width) {
                        $(target).lookup('resize', width);
                    }
                }
            });
        }

        $.extend($.fn.datagrid.defaults.editors, {
            label: {
                init: function (container, options) {
                    var input = $('<div></div>').appendTo(container);
                    return input;
                },
                destroy: function (target) {

                },
                getValue: function (target) {
                    return $(target).html();
                },
                setValue: function (target, value) {
                    $(target).html(value);
                },
                resize: function (target, width) {

                }
            }
        });
    }
}
