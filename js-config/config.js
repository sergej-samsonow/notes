document.addEventListener('DOMContentLoaded', function() {

// configure objects
var configure = function(callable, value) {
    var parts   = callable.split('.');
    var object  = undefined;
    var func    = undefined;
    if (parts.length == 2) {
        object  = parts[0];
        func    = parts[1];
    }
    else if (parts.length == 1) {
        func    = parts[0];
    }
    if ( object                 != undefined
      && func                   != undefined 
      && window[object]         != undefined
      && window[object][func]   != undefined) {
        window[object][func](value);
    }
    else if ( func != undefined && window[func] != undefined) {
        window[func](value);
    } 
};

// parse configuration
var tables          = document.getElementsByClassName('config');
for (var table = 0; table < tables.length; table ++) {
    var entries = tables[table].getElementsByTagName('tr');
    for (var entry = 0; entry < entries.length; entry ++) {
        var data    = entries[entry].getElementsByTagName('td'); 
        var object  = data[0].textContent;
        var value   = data[1].textContent;    
        configure(object, value);
    }
}


});
