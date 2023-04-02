<!-- README.md -->
<!DOCTYPE html>
<html>
  <head>
    <style>
      .code-container {
        counter-reset: linenumber;
      }
      .code-container pre {
        counter-increment: linenumber;
        margin-top: 0;
        margin-bottom: 0;
      }
      .code-container pre:before {
        content: counter(linenumber);
        display: inline-block;
        padding-right: 0.5em;
        width: 2em;
        text-align: right;
        color: #999;
      }
    </style>
  </head>
  <body>
    <div class="code-container">
      <pre data-line-numbers="1-3"><code>var x = 1;
var y = 2;
var z = x + y;</code></pre>
    </div>
  </body>
</html>
