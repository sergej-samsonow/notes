(function() {
    var module = function() {
        var namespce    = '';
        var modules     = {};
        return {
            start : function(current) {
                namespce = current;
            },
            use : function(name) {
                return modules[name];
            },
            publish : function(name, entry) {
                modules[namespce + '.' + name] = entry;
            }
        }
    }();
    var use        = module.use;
    var publish    = module.publish;
    var start      = module.start;
    module = undefined;
    
    // bad module
    start('shared.badmodule');
    (function(use, publish, start) {
        use = undefined;
        publish = undefined;
    })(use, publish, undefined);

    // Module logger
    start('shared.logger');
    (function(use, publish, start) {
        publish('log', function(message) {
            console.log(message); 
        });
    })(use, publish, undefined);

    // Module improver logger
    start('shared.logger.v2');
    (function(use, publish, start) {

        var counter = 0;
        publish('log', function(message) {
            counter ++;
            console.log('[LOG]' + message); 
        });
        publish('log_counts', function() {    
            return counter;
        });

    })(use, publish, undefined);


    // Calculator
    start('shared.calculator');
    (function(use, publish, start) {
        var log = use('shared.logger.log');
        var calulator = function() {
            return {
                addition : function(a, b) {
                    var r = (1 * a) + (1 * b);
                    log( a + ' + ' + b + ' = ' + r);
                    return r;
                },
                subtraction : function(a, b) {
                    var r = (1 * a) - (1 * b);
                    log(a + ' - ' + b + ' = ' + r);
                    return r; 
                }
            } 
        }(); 
        publish('calulator', calulator);
    })(use, publish, undefined);


    // Application module
    start('pages.calc');
    (function(use, publish, start) {
        var log     = use('shared.logger.v2.log');
        var count   = use('shared.logger.v2.log_counts');
        var calc    = use('shared.calculator.calulator');
        var a, b, r, i, add, sub;
        var check = function(a, b) {
            if (isNaN(a)) {
                log('a is NaN: ' + a);
                return false;
            }
            if (isNaN(b)) {
                log('b is NaN: ' + b);
                return false; 
            }
            return true;
        } 
        document.addEventListener('DOMContentLoaded', function() {
            a   = document.getElementById('a'); // a input
            b   = document.getElementById('b'); // b input
            r   = document.getElementById('r'); // result text
            i   = document.getElementById('i'); // logs count info (alert)
            add = document.getElementById('add'); // addtion
            sub = document.getElementById('sub'); // subtraction
            add.addEventListener('click', function() {
                var a_value = a.value;
                var b_value = b.value;
                if (check(a_value, b_value)) {
                    r.textContent = calc.addition(a_value, b_value);
                }
            });
            sub.addEventListener('click', function() {
                var a_value = a.value;
                var b_value = b.value;
                if (check(a_value, b_value)) {
                    r.textContent = calc.subtraction(a_value, b_value);
                }
            });
            i.addEventListener('click', function() {
                alert('Logs count: ' + count());
            });
        });
    })(use, publish, undefined);

})();
