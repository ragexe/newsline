<%--
  Created by IntelliJ IDEA.
  User: ragexe
  Date: 07.06.2015
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Bootswatch: Superhero</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <link rel="stylesheet" href="../asserts/css/bootstrap.css" media="screen">
  <link rel="stylesheet" href="../asserts/css/bootswatch.min.css">
  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="../bower_components/html5shiv/dist/html5shiv.js"></script>
  <script src="../bower_components/respond/dest/respond.min.js"></script>
  <![endif]-->
  <script>

    var _gaq = _gaq || [];
    _gaq.push(['_setAccount', 'UA-23019901-1']);
    _gaq.push(['_setDomainName', "bootswatch.com"]);
    _gaq.push(['_setAllowLinker', true]);
    _gaq.push(['_trackPageview']);

    (function() {
      var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
      ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
      var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
    })();

  </script>
</head>
<body>
<div class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <a href="../" class="navbar-brand">Bootswatch</a>
      <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>
    <div class="navbar-collapse collapse" id="navbar-main">
      <ul class="nav navbar-nav">
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="themes">Themes <span class="caret"></span></a>
          <ul class="dropdown-menu" aria-labelledby="themes">
            <li><a href="../default/">Default</a></li>
            <li class="divider"></li>
            <li><a href="../cerulean/">Cerulean</a></li>
            <li><a href="../cosmo/">Cosmo</a></li>
            <li><a href="../cyborg/">Cyborg</a></li>
            <li><a href="../darkly/">Darkly</a></li>
            <li><a href="../flatly/">Flatly</a></li>
            <li><a href="../journal/">Journal</a></li>
            <li><a href="../lumen/">Lumen</a></li>
            <li><a href="../paper/">Paper</a></li>
            <li><a href="../readable/">Readable</a></li>
            <li><a href="../sandstone/">Sandstone</a></li>
            <li><a href="../simplex/">Simplex</a></li>
            <li><a href="../slate/">Slate</a></li>
            <li><a href="../spacelab/">Spacelab</a></li>
            <li><a href="../superhero/">Superhero</a></li>
            <li><a href="../united/">United</a></li>
            <li><a href="../yeti/">Yeti</a></li>
          </ul>
        </li>
        <li>
          <a href="../help/">Help</a>
        </li>
        <li>
          <a href="http://news.bootswatch.com">Blog</a>
        </li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="download">Download <span class="caret"></span></a>
          <ul class="dropdown-menu" aria-labelledby="download">
            <li><a href="./bootstrap.min.css">bootstrap.min.css</a></li>
            <li><a href="./bootstrap.css">bootstrap.css</a></li>
            <li class="divider"></li>
            <li><a href="./variables.less">variables.less</a></li>
            <li><a href="./bootswatch.less">bootswatch.less</a></li>
            <li class="divider"></li>
            <li><a href="./_variables.scss">_variables.scss</a></li>
            <li><a href="./_bootswatch.scss">_bootswatch.scss</a></li>
          </ul>
        </li>
      </ul>

      <ul class="nav navbar-nav navbar-right">
        <li><a href="http://builtwithbootstrap.com/" target="_blank">Built With Bootstrap</a></li>
        <li><a href="https://wrapbootstrap.com/?ref=bsw" target="_blank">WrapBootstrap</a></li>
      </ul>

    </div>
  </div>
</div>


<div class="container">

  <div class="page-header" id="banner">
    <div class="row">
      <div class="col-lg-8 col-md-7 col-sm-6">
        <h1>Superhero</h1>
        <p class="lead">The brave and the blue</p>
      </div>
      <div class="col-lg-4 col-md-5 col-sm-6">
        <div class="sponsor">
          <a href="http://www.shopify.com/?ref=bootswatch" target="_blank" onclick="_gaq.push(['_trackEvent', 'banner', 'click', 'shopify']);">
            <img src="../assets/img/shopify.png" alt="Shopify" width="180" height="150" onload="_gaq.push(['_trackEvent', 'banner', 'impression', 'shopify']);">
          </a>
        </div>
      </div>
    </div>
  </div>

  <!-- Navbar
  ================================================== -->
  <div class="bs-docs-section clearfix">
    <div class="row">
      <div class="col-lg-12">
        <div class="page-header">
          <h1 id="navbar">Navbar</h1>
        </div>

        <div class="bs-component">
          <nav class="navbar navbar-default">
            <div class="container-fluid">
              <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                  <span class="sr-only">Toggle navigation</span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Brand</a>
              </div>

              <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                  <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
                  <li><a href="#">Link</a></li>
                  <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                      <li><a href="#">Action</a></li>
                      <li><a href="#">Another action</a></li>
                      <li><a href="#">Something else here</a></li>
                      <li class="divider"></li>
                      <li><a href="#">Separated link</a></li>
                      <li class="divider"></li>
                      <li><a href="#">One more separated link</a></li>
                    </ul>
                  </li>
                </ul>
                <form class="navbar-form navbar-left" role="search">
                  <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                  </div>
                  <button type="submit" class="btn btn-default">Submit</button>
                </form>
                <ul class="nav navbar-nav navbar-right">
                  <li><a href="#">Link</a></li>
                </ul>
              </div>
            </div>
          </nav>
        </div>

        <div class="bs-component">
          <nav class="navbar navbar-inverse">
            <div class="container-fluid">
              <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
                  <span class="sr-only">Toggle navigation</span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Brand</a>
              </div>

              <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
                <ul class="nav navbar-nav">
                  <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
                  <li><a href="#">Link</a></li>
                  <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                      <li><a href="#">Action</a></li>
                      <li><a href="#">Another action</a></li>
                      <li><a href="#">Something else here</a></li>
                      <li class="divider"></li>
                      <li><a href="#">Separated link</a></li>
                      <li class="divider"></li>
                      <li><a href="#">One more separated link</a></li>
                    </ul>
                  </li>
                </ul>
                <form class="navbar-form navbar-left" role="search">
                  <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                  </div>
                  <button type="submit" class="btn btn-default">Submit</button>
                </form>
                <ul class="nav navbar-nav navbar-right">
                  <li><a href="#">Link</a></li>
                </ul>
              </div>
            </div>
          </nav>
        </div><!-- /example -->

      </div>
    </div>
  </div>


  <!-- Buttons
  ================================================== -->
  <div class="bs-docs-section">
    <div class="page-header">
      <div class="row">
        <div class="col-lg-12">
          <h1 id="buttons">Buttons</h1>
        </div>
      </div>
    </div>

    <div class="row">
      <div class="col-lg-6">

        <p class="bs-component">
          <a href="#" class="btn btn-default">Default</a>
          <a href="#" class="btn btn-primary">Primary</a>
          <a href="#" class="btn btn-success">Success</a>
          <a href="#" class="btn btn-info">Info</a>
          <a href="#" class="btn btn-warning">Warning</a>
          <a href="#" class="btn btn-danger">Danger</a>
          <a href="#" class="btn btn-link">Link</a>
        </p>

        <p class="bs-component">
          <a href="#" class="btn btn-default disabled">Default</a>
          <a href="#" class="btn btn-primary disabled">Primary</a>
          <a href="#" class="btn btn-success disabled">Success</a>
          <a href="#" class="btn btn-info disabled">Info</a>
          <a href="#" class="btn btn-warning disabled">Warning</a>
          <a href="#" class="btn btn-danger disabled">Danger</a>
          <a href="#" class="btn btn-link disabled">Link</a>
        </p>


        <div style="margin-bottom: 15px;">
          <div class="btn-toolbar bs-component" style="margin: 0;">
            <div class="btn-group">
              <a href="#" class="btn btn-default">Default</a>
              <a href="#" class="btn btn-default dropdown-toggle" data-toggle="dropdown"><span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li class="divider"></li>
                <li><a href="#">Separated link</a></li>
              </ul>
            </div>

            <div class="btn-group">
              <a href="#" class="btn btn-primary">Primary</a>
              <a href="#" class="btn btn-primary dropdown-toggle" data-toggle="dropdown"><span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li class="divider"></li>
                <li><a href="#">Separated link</a></li>
              </ul>
            </div>

            <div class="btn-group">
              <a href="#" class="btn btn-success">Success</a>
              <a href="#" class="btn btn-success dropdown-toggle" data-toggle="dropdown"><span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li class="divider"></li>
                <li><a href="#">Separated link</a></li>
              </ul>
            </div>

            <div class="btn-group">
              <a href="#" class="btn btn-info">Info</a>
              <a href="#" class="btn btn-info dropdown-toggle" data-toggle="dropdown"><span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li class="divider"></li>
                <li><a href="#">Separated link</a></li>
              </ul>
            </div>

            <div class="btn-group">
              <a href="#" class="btn btn-warning">Warning</a>
              <a href="#" class="btn btn-warning dropdown-toggle" data-toggle="dropdown"><span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li class="divider"></li>
                <li><a href="#">Separated link</a></li>
              </ul>
            </div>
          </div>
        </div>

        <p class="bs-component">
          <a href="#" class="btn btn-primary btn-lg">Large button</a>
          <a href="#" class="btn btn-primary">Default button</a>
          <a href="#" class="btn btn-primary btn-sm">Small button</a>
          <a href="#" class="btn btn-primary btn-xs">Mini button</a>
        </p>

      </div>
      <div class="col-lg-6">

        <p class="bs-component">
          <a href="#" class="btn btn-default btn-lg btn-block">Block level button</a>
        </p>


        <div class="bs-component" style="margin-bottom: 15px;">
          <div class="btn-group btn-group-justified">
            <a href="#" class="btn btn-default">Left</a>
            <a href="#" class="btn btn-default">Middle</a>
            <a href="#" class="btn btn-default">Right</a>
          </div>
        </div>

        <div class="bs-component" style="margin-bottom: 15px;">
          <div class="btn-toolbar">
            <div class="btn-group">
              <a href="#" class="btn btn-default">1</a>
              <a href="#" class="btn btn-default">2</a>
              <a href="#" class="btn btn-default">3</a>
              <a href="#" class="btn btn-default">4</a>
            </div>

            <div class="btn-group">
              <a href="#" class="btn btn-default">5</a>
              <a href="#" class="btn btn-default">6</a>
              <a href="#" class="btn btn-default">7</a>
            </div>

            <div class="btn-group">
              <a href="#" class="btn btn-default">8</a>
              <div class="btn-group">
                <a href="#" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                  Dropdown
                  <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                  <li><a href="#">Dropdown link</a></li>
                  <li><a href="#">Dropdown link</a></li>
                  <li><a href="#">Dropdown link</a></li>
                </ul>
              </div>
            </div>
          </div>
        </div>

        <div class="bs-component">
          <div class="btn-group-vertical">
            <a href="#" class="btn btn-default">Button</a>
            <a href="#" class="btn btn-default">Button</a>
            <a href="#" class="btn btn-default">Button</a>
            <a href="#" class="btn btn-default">Button</a>
          </div>
        </div>

      </div>
    </div>
  </div>

  <!-- Typography
  ================================================== -->
  <div class="bs-docs-section">
    <div class="row">
      <div class="col-lg-12">
        <div class="page-header">
          <h1 id="type">Typography</h1>
        </div>
      </div>
    </div>

    <!-- Headings -->

    <div class="row">
      <div class="col-lg-4">
        <div class="bs-component">
          <h1>Heading 1</h1>
          <h2>Heading 2</h2>
          <h3>Heading 3</h3>
          <h4>Heading 4</h4>
          <h5>Heading 5</h5>
          <h6>Heading 6</h6>
          <p class="lead">Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor.</p>
        </div>
      </div>
      <div class="col-lg-4">
        <div class="bs-component">
          <h2>Example body text</h2>
          <p>Nullam quis risus eget <a href="#">urna mollis ornare</a> vel eu leo. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nullam id dolor id nibh ultricies vehicula.</p>
          <p><small>This line of text is meant to be treated as fine print.</small></p>
          <p>The following snippet of text is <strong>rendered as bold text</strong>.</p>
          <p>The following snippet of text is <em>rendered as italicized text</em>.</p>
          <p>An abbreviation of the word attribute is <abbr title="attribute">attr</abbr>.</p>
        </div>

      </div>
      <div class="col-lg-4">
        <div class="bs-component">
          <h2>Emphasis classes</h2>
          <p class="text-muted">Fusce dapibus, tellus ac cursus commodo, tortor mauris nibh.</p>
          <p class="text-primary">Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
          <p class="text-warning">Etiam porta sem malesuada magna mollis euismod.</p>
          <p class="text-danger">Donec ullamcorper nulla non metus auctor fringilla.</p>
          <p class="text-success">Duis mollis, est non commodo luctus, nisi erat porttitor ligula.</p>
          <p class="text-info">Maecenas sed diam eget risus varius blandit sit amet non magna.</p>
        </div>

      </div>
    </div>

    <!-- Blockquotes -->

    <div class="row">
      <div class="col-lg-12">
        <h2 id="type-blockquotes">Blockquotes</h2>
      </div>
    </div>
    <div class="row">
      <div class="col-lg-6">
        <div class="bs-component">
          <blockquote>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
            <small>Someone famous in <cite title="Source Title">Source Title</cite></small>
          </blockquote>
        </div>
      </div>
      <div class="col-lg-6">
        <div class="bs-component">
          <blockquote class="pull-right">
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
            <small>Someone famous in <cite title="Source Title">Source Title</cite></small>
          </blockquote>
        </div>
      </div>
    </div>
  </div>

  <!-- Tables
  ================================================== -->
  <div class="bs-docs-section">

    <div class="row">
      <div class="col-lg-12">
        <div class="page-header">
          <h1 id="tables">Tables</h1>
        </div>

        <div class="bs-component">
          <table class="table table-striped table-hover ">
            <thead>
            <tr>
              <th>#</th>
              <th>Column heading</th>
              <th>Column heading</th>
              <th>Column heading</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>1</td>
              <td>Column content</td>
              <td>Column content</td>
              <td>Column content</td>
            </tr>
            <tr>
              <td>2</td>
              <td>Column content</td>
              <td>Column content</td>
              <td>Column content</td>
            </tr>
            <tr class="info">
              <td>3</td>
              <td>Column content</td>
              <td>Column content</td>
              <td>Column content</td>
            </tr>
            <tr class="success">
              <td>4</td>
              <td>Column content</td>
              <td>Column content</td>
              <td>Column content</td>
            </tr>
            <tr class="danger">
              <td>5</td>
              <td>Column content</td>
              <td>Column content</td>
              <td>Column content</td>
            </tr>
            <tr class="warning">
              <td>6</td>
              <td>Column content</td>
              <td>Column content</td>
              <td>Column content</td>
            </tr>
            <tr class="active">
              <td>7</td>
              <td>Column content</td>
              <td>Column content</td>
              <td>Column content</td>
            </tr>
            </tbody>
          </table>
        </div><!-- /example -->
      </div>
    </div>
  </div>

  <!-- Forms
  ================================================== -->
  <div class="bs-docs-section">
    <div class="row">
      <div class="col-lg-12">
        <div class="page-header">
          <h1 id="forms">Forms</h1>
        </div>
      </div>
    </div>

    <div class="row">
      <div class="col-lg-6">
        <div class="well bs-component">
          <form class="form-horizontal">
            <fieldset>
              <legend>Legend</legend>
              <div class="form-group">
                <label for="inputEmail" class="col-lg-2 control-label">Email</label>
                <div class="col-lg-10">
                  <input type="text" class="form-control" id="inputEmail" placeholder="Email">
                </div>
              </div>
              <div class="form-group">
                <label for="inputPassword" class="col-lg-2 control-label">Password</label>
                <div class="col-lg-10">
                  <input type="password" class="form-control" id="inputPassword" placeholder="Password">
                  <div class="checkbox">
                    <label>
                      <input type="checkbox"> Checkbox
                    </label>
                  </div>
                </div>
              </div>
              <div class="form-group">
                <label for="textArea" class="col-lg-2 control-label">Textarea</label>
                <div class="col-lg-10">
                  <textarea class="form-control" rows="3" id="textArea"></textarea>
                  <span class="help-block">A longer block of help text that breaks onto a new line and may extend beyond one line.</span>
                </div>
              </div>
              <div class="form-group">
                <label class="col-lg-2 control-label">Radios</label>
                <div class="col-lg-10">
                  <div class="radio">
                    <label>
                      <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked="">
                      Option one is this
                    </label>
                  </div>
                  <div class="radio">
                    <label>
                      <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
                      Option two can be something else
                    </label>
                  </div>
                </div>
              </div>
              <div class="form-group">
                <label for="select" class="col-lg-2 control-label">Selects</label>
                <div class="col-lg-10">
                  <select class="form-control" id="select">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                  </select>
                  <br>
                  <select multiple="" class="form-control">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                  </select>
                </div>
              </div>
              <div class="form-group">
                <div class="col-lg-10 col-lg-offset-2">
                  <button type="reset" class="btn btn-default">Cancel</button>
                  <button type="submit" class="btn btn-primary">Submit</button>
                </div>
              </div>
            </fieldset>
          </form>
        </div>
      </div>
      <div class="col-lg-4 col-lg-offset-1">

        <form class="bs-component">
          <div class="form-group">
            <label class="control-label" for="focusedInput">Focused input</label>
            <input class="form-control" id="focusedInput" type="text" value="This is focused...">
          </div>

          <div class="form-group">
            <label class="control-label" for="disabledInput">Disabled input</label>
            <input class="form-control" id="disabledInput" type="text" placeholder="Disabled input here..." disabled="">
          </div>

          <div class="form-group has-warning">
            <label class="control-label" for="inputWarning">Input warning</label>
            <input type="text" class="form-control" id="inputWarning">
          </div>

          <div class="form-group has-error">
            <label class="control-label" for="inputError">Input error</label>
            <input type="text" class="form-control" id="inputError">
          </div>

          <div class="form-group has-success">
            <label class="control-label" for="inputSuccess">Input success</label>
            <input type="text" class="form-control" id="inputSuccess">
          </div>

          <div class="form-group">
            <label class="control-label" for="inputLarge">Large input</label>
            <input class="form-control input-lg" type="text" id="inputLarge">
          </div>

          <div class="form-group">
            <label class="control-label" for="inputDefault">Default input</label>
            <input type="text" class="form-control" id="inputDefault">
          </div>

          <div class="form-group">
            <label class="control-label" for="inputSmall">Small input</label>
            <input class="form-control input-sm" type="text" id="inputSmall">
          </div>

          <div class="form-group">
            <label class="control-label">Input addons</label>
            <div class="input-group">
              <span class="input-group-addon">$</span>
              <input type="text" class="form-control">
                    <span class="input-group-btn">
                      <button class="btn btn-default" type="button">Button</button>
                    </span>
            </div>
          </div>
        </form>

      </div>
    </div>
  </div>

  <!-- Navs
  ================================================== -->
  <div class="bs-docs-section">

    <div class="row">
      <div class="col-lg-12">
        <div class="page-header">
          <h1 id="nav">Navs</h1>
        </div>
      </div>
    </div>

    <div class="row">
      <div class="col-lg-4">
        <h2 id="nav-tabs">Tabs</h2>
        <div class="bs-component">
          <ul class="nav nav-tabs">
            <li class="active"><a href="#home" data-toggle="tab">Home</a></li>
            <li><a href="#profile" data-toggle="tab">Profile</a></li>
            <li class="disabled"><a>Disabled</a></li>
            <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                Dropdown <span class="caret"></span>
              </a>
              <ul class="dropdown-menu">
                <li><a href="#dropdown1" data-toggle="tab">Action</a></li>
                <li class="divider"></li>
                <li><a href="#dropdown2" data-toggle="tab">Another action</a></li>
              </ul>
            </li>
          </ul>
          <div id="myTabContent" class="tab-content">
            <div class="tab-pane fade active in" id="home">
              <p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui.</p>
            </div>
            <div class="tab-pane fade" id="profile">
              <p>Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid. Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson artisan four loko farm-to-table craft beer twee. Qui photo booth letterpress, commodo enim craft beer mlkshk aliquip jean shorts ullamco ad vinyl cillum PBR. Homo nostrud organic, assumenda labore aesthetic magna delectus mollit.</p>
            </div>
            <div class="tab-pane fade" id="dropdown1">
              <p>Etsy mixtape wayfarers, ethical wes anderson tofu before they sold out mcsweeney's organic lomo retro fanny pack lo-fi farm-to-table readymade. Messenger bag gentrify pitchfork tattooed craft beer, iphone skateboard locavore carles etsy salvia banksy hoodie helvetica. DIY synth PBR banksy irony. Leggings gentrify squid 8-bit cred pitchfork.</p>
            </div>
            <div class="tab-pane fade" id="dropdown2">
              <p>Trust fund seitan letterpress, keytar raw denim keffiyeh etsy art party before they sold out master cleanse gluten-free squid scenester freegan cosby sweater. Fanny pack portland seitan DIY, art party locavore wolf cliche high life echo park Austin. Cred vinyl keffiyeh DIY salvia PBR, banh mi before they sold out farm-to-table VHS viral locavore cosby sweater.</p>
            </div>
          </div>
        </div>
      </div>
      <div class="col-lg-4">
        <h2 id="nav-pills">Pills</h2>
        <div class="bs-component">
          <ul class="nav nav-pills">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#">Profile</a></li>
            <li class="disabled"><a href="#">Disabled</a></li>
            <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                Dropdown <span class="caret"></span>
              </a>
              <ul class="dropdown-menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li class="divider"></li>
                <li><a href="#">Separated link</a></li>
              </ul>
            </li>
          </ul>
        </div>
        <br>
        <div class="bs-component">
          <ul class="nav nav-pills nav-stacked">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#">Profile</a></li>
            <li class="disabled"><a href="#">Disabled</a></li>
            <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                Dropdown <span class="caret"></span>
              </a>
              <ul class="dropdown-menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li class="divider"></li>
                <li><a href="#">Separated link</a></li>
              </ul>
            </li>
          </ul>
        </div>
      </div>
      <div class="col-lg-4">
        <h2 id="nav-breadcrumbs">Breadcrumbs</h2>
        <div class="bs-component">
          <ul class="breadcrumb">
            <li class="active">Home</li>
          </ul>

          <ul class="breadcrumb">
            <li><a href="#">Home</a></li>
            <li class="active">Library</li>
          </ul>

          <ul class="breadcrumb">
            <li><a href="#">Home</a></li>
            <li><a href="#">Library</a></li>
            <li class="active">Data</li>
          </ul>
        </div>

      </div>
    </div>


    <div class="row">
      <div class="col-lg-4">
        <h2 id="pagination">Pagination</h2>
        <div class="bs-component">
          <ul class="pagination">
            <li class="disabled"><a href="#">&laquo;</a></li>
            <li class="active"><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#">&raquo;</a></li>
          </ul>

          <ul class="pagination pagination-lg">
            <li class="disabled"><a href="#">&laquo;</a></li>
            <li class="active"><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">&raquo;</a></li>
          </ul>

          <ul class="pagination pagination-sm">
            <li class="disabled"><a href="#">&laquo;</a></li>
            <li class="active"><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#">&raquo;</a></li>
          </ul>
        </div>
      </div>
      <div class="col-lg-4">
        <h2 id="pager">Pager</h2>
        <div class="bs-component">
          <ul class="pager">
            <li><a href="#">Previous</a></li>
            <li><a href="#">Next</a></li>
          </ul>

          <ul class="pager">
            <li class="previous disabled"><a href="#">&larr; Older</a></li>
            <li class="next"><a href="#">Newer &rarr;</a></li>
          </ul>
        </div>
      </div>
      <div class="col-lg-4">

      </div>
    </div>
  </div>

  <!-- Indicators
  ================================================== -->
  <div class="bs-docs-section">

    <div class="row">
      <div class="col-lg-12">
        <div class="page-header">
          <h1 id="indicators">Indicators</h1>
        </div>
      </div>
    </div>

    <div class="row">
      <div class="col-lg-12">
        <h2>Alerts</h2>
        <div class="bs-component">
          <div class="alert alert-dismissible alert-warning">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <h4>Warning!</h4>
            <p>Best check yo self, you're not looking too good. Nulla vitae elit libero, a pharetra augue. Praesent commodo cursus magna, <a href="#" class="alert-link">vel scelerisque nisl consectetur et</a>.</p>
          </div>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-lg-4">
        <div class="bs-component">
          <div class="alert alert-dismissible alert-danger">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <strong>Oh snap!</strong> <a href="#" class="alert-link">Change a few things up</a> and try submitting again.
          </div>
        </div>
      </div>
      <div class="col-lg-4">
        <div class="bs-component">
          <div class="alert alert-dismissible alert-success">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <strong>Well done!</strong> You successfully read <a href="#" class="alert-link">this important alert message</a>.
          </div>
        </div>
      </div>
      <div class="col-lg-4">
        <div class="bs-component">
          <div class="alert alert-dismissible alert-info">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <strong>Heads up!</strong> This <a href="#" class="alert-link">alert needs your attention</a>, but it's not super important.
          </div>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-lg-4">
        <h2>Labels</h2>
        <div class="bs-component" style="margin-bottom: 40px;">
          <span class="label label-default">Default</span>
          <span class="label label-primary">Primary</span>
          <span class="label label-success">Success</span>
          <span class="label label-warning">Warning</span>
          <span class="label label-danger">Danger</span>
          <span class="label label-info">Info</span>
        </div>
      </div>
      <div class="col-lg-4">
        <h2>Badges</h2>
        <div class="bs-component">
          <ul class="nav nav-pills">
            <li class="active"><a href="#">Home <span class="badge">42</span></a></li>
            <li><a href="#">Profile <span class="badge"></span></a></li>
            <li><a href="#">Messages <span class="badge">3</span></a></li>
          </ul>
        </div>
      </div>
    </div>
  </div>

  <!-- Progress bars
  ================================================== -->
  <div class="bs-docs-section">

    <div class="row">
      <div class="col-lg-12">
        <div class="page-header">
          <h1 id="progress">Progress bars</h1>
        </div>

        <h3 id="progress-basic">Basic</h3>
        <div class="bs-component">
          <div class="progress">
            <div class="progress-bar" style="width: 60%;"></div>
          </div>
        </div>

        <h3 id="progress-alternatives">Contextual alternatives</h3>
        <div class="bs-component">
          <div class="progress">
            <div class="progress-bar progress-bar-info" style="width: 20%"></div>
          </div>

          <div class="progress">
            <div class="progress-bar progress-bar-success" style="width: 40%"></div>
          </div>

          <div class="progress">
            <div class="progress-bar progress-bar-warning" style="width: 60%"></div>
          </div>

          <div class="progress">
            <div class="progress-bar progress-bar-danger" style="width: 80%"></div>
          </div>
        </div>

        <h3 id="progress-striped">Striped</h3>
        <div class="bs-component">
          <div class="progress progress-striped">
            <div class="progress-bar progress-bar-info" style="width: 20%"></div>
          </div>

          <div class="progress progress-striped">
            <div class="progress-bar progress-bar-success" style="width: 40%"></div>
          </div>

          <div class="progress progress-striped">
            <div class="progress-bar progress-bar-warning" style="width: 60%"></div>
          </div>

          <div class="progress progress-striped">
            <div class="progress-bar progress-bar-danger" style="width: 80%"></div>
          </div>
        </div>

        <h3 id="progress-animated">Animated</h3>
        <div class="bs-component">
          <div class="progress progress-striped active">
            <div class="progress-bar" style="width: 45%"></div>
          </div>
        </div>

        <h3 id="progress-stacked">Stacked</h3>
        <div class="bs-component">
          <div class="progress">
            <div class="progress-bar progress-bar-success" style="width: 35%"></div>
            <div class="progress-bar progress-bar-warning" style="width: 20%"></div>
            <div class="progress-bar progress-bar-danger" style="width: 10%"></div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- Containers
  ================================================== -->
  <div class="bs-docs-section">

    <div class="row">
      <div class="col-lg-12">
        <div class="page-header">
          <h1 id="container">Containers</h1>
        </div>
        <div class="bs-component">
          <div class="jumbotron">
            <h1>Jumbotron</h1>
            <p>This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
            <p><a class="btn btn-primary btn-lg">Learn more</a></p>
          </div>
        </div>
      </div>
    </div>


    <div class="row">
      <div class="col-lg-12">
        <h2>List groups</h2>
      </div>
    </div>
    <div class="row">
      <div class="col-lg-4">
        <div class="bs-component">
          <ul class="list-group">
            <li class="list-group-item">
              <span class="badge">14</span>
              Cras justo odio
            </li>
            <li class="list-group-item">
              <span class="badge">2</span>
              Dapibus ac facilisis in
            </li>
            <li class="list-group-item">
              <span class="badge">1</span>
              Morbi leo risus
            </li>
          </ul>
        </div>
      </div>
      <div class="col-lg-4">
        <div class="bs-component">
          <div class="list-group">
            <a href="#" class="list-group-item active">
              Cras justo odio
            </a>
            <a href="#" class="list-group-item">Dapibus ac facilisis in
            </a>
            <a href="#" class="list-group-item">Morbi leo risus
            </a>
          </div>
        </div>
      </div>
      <div class="col-lg-4">
        <div class="bs-component">
          <div class="list-group">
            <a href="#" class="list-group-item">
              <h4 class="list-group-item-heading">List group item heading</h4>
              <p class="list-group-item-text">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>
            </a>
            <a href="#" class="list-group-item">
              <h4 class="list-group-item-heading">List group item heading</h4>
              <p class="list-group-item-text">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>
            </a>
          </div>
        </div>
      </div>
    </div>


    <div class="row">
      <div class="col-lg-12">
        <h2>Panels</h2>
      </div>
    </div>
    <div class="row">
      <div class="col-lg-4">
        <div class="bs-component">
          <div class="panel panel-default">
            <div class="panel-body">
              Basic panel
            </div>
          </div>

          <div class="panel panel-default">
            <div class="panel-heading">Panel heading</div>
            <div class="panel-body">
              Panel content
            </div>
          </div>

          <div class="panel panel-default">
            <div class="panel-body">
              Panel content
            </div>
            <div class="panel-footer">Panel footer</div>
          </div>
        </div>
      </div>
      <div class="col-lg-4">
        <div class="bs-component">
          <div class="panel panel-primary">
            <div class="panel-heading">
              <h3 class="panel-title">Panel primary</h3>
            </div>
            <div class="panel-body">
              Panel content
            </div>
          </div>

          <div class="panel panel-success">
            <div class="panel-heading">
              <h3 class="panel-title">Panel success</h3>
            </div>
            <div class="panel-body">
              Panel content
            </div>
          </div>

          <div class="panel panel-warning">
            <div class="panel-heading">
              <h3 class="panel-title">Panel warning</h3>
            </div>
            <div class="panel-body">
              Panel content
            </div>
          </div>
        </div>
      </div>
      <div class="col-lg-4">
        <div class="bs-component">
          <div class="panel panel-danger">
            <div class="panel-heading">
              <h3 class="panel-title">Panel danger</h3>
            </div>
            <div class="panel-body">
              Panel content
            </div>
          </div>

          <div class="panel panel-info">
            <div class="panel-heading">
              <h3 class="panel-title">Panel info</h3>
            </div>
            <div class="panel-body">
              Panel content
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="row">
      <div class="col-lg-12">
        <h2>Wells</h2>
      </div>
    </div>
    <div class="row">
      <div class="col-lg-4">
        <div class="bs-component">
          <div class="well">
            Look, I'm in a well!
          </div>
        </div>
      </div>
      <div class="col-lg-4">
        <div class="bs-component">
          <div class="well well-sm">
            Look, I'm in a small well!
          </div>
        </div>
      </div>
      <div class="col-lg-4">
        <div class="bs-component">
          <div class="well well-lg">
            Look, I'm in a large well!
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- Dialogs
  ================================================== -->
  <div class="bs-docs-section">

    <div class="row">
      <div class="col-lg-12">
        <div class="page-header">
          <h1 id="dialogs">Dialogs</h1>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-lg-6">
        <h2>Modals</h2>
        <div class="bs-component">
          <div class="modal">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                  <h4 class="modal-title">Modal title</h4>
                </div>
                <div class="modal-body">
                  <p>One fine body…</p>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                  <button type="button" class="btn btn-primary">Save changes</button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="col-lg-6">
        <h2>Popovers</h2>
        <div class="bs-component">
          <button type="button" class="btn btn-default" data-container="body" data-toggle="popover" data-placement="left" data-content="Vivamus sagittis lacus vel augue laoreet rutrum faucibus.">Left</button>

          <button type="button" class="btn btn-default" data-container="body" data-toggle="popover" data-placement="top" data-content="Vivamus sagittis lacus vel augue laoreet rutrum faucibus.">Top</button>

          <button type="button" class="btn btn-default" data-container="body" data-toggle="popover" data-placement="bottom" data-content="Vivamus
              sagittis lacus vel augue laoreet rutrum faucibus.">Bottom</button>

          <button type="button" class="btn btn-default" data-container="body" data-toggle="popover" data-placement="right" data-content="Vivamus sagittis lacus vel augue laoreet rutrum faucibus.">Right</button>
        </div>
        <h2>Tooltips</h2>
        <div class="bs-component">
          <button type="button" class="btn btn-default" data-toggle="tooltip" data-placement="left" title="" data-original-title="Tooltip on left">Left</button>

          <button type="button" class="btn btn-default" data-toggle="tooltip" data-placement="top" title="" data-original-title="Tooltip on top">Top</button>

          <button type="button" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="Tooltip on bottom">Bottom</button>

          <button type="button" class="btn btn-default" data-toggle="tooltip" data-placement="right" title="" data-original-title="Tooltip on right">Right</button>
        </div>
      </div>
    </div>
  </div>

  <div id="source-modal" class="modal fade">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4 class="modal-title">Source Code</h4>
        </div>
        <div class="modal-body">
          <pre></pre>
        </div>
      </div>
    </div>
  </div>

  <footer>
    <div class="row">
      <div class="col-lg-12">

        <ul class="list-unstyled">
          <li class="pull-right"><a href="#top">Back to top</a></li>
          <li><a href="http://news.bootswatch.com" onclick="pageTracker._link(this.href); return false;">Blog</a></li>
          <li><a href="http://feeds.feedburner.com/bootswatch">RSS</a></li>
          <li><a href="https://twitter.com/bootswatch">Twitter</a></li>
          <li><a href="https://github.com/thomaspark/bootswatch/">GitHub</a></li>
          <li><a href="../help/#api">API</a></li>
          <li><a href="../help/#support">Support</a></li>
        </ul>
        <p>Made by <a href="http://thomaspark.co" rel="nofollow">Thomas Park</a>. Contact him at <a href="/cdn-cgi/l/email-protection#6014080f0d011320020f0f141317011403084e030f0d"><span class="__cf_email__" data-cfemail="04706c6b69657744666b6b7077736570676c2a676b69">[email&#160;protected]</span><script cf-hash='f9e31' type="text/javascript">
          /* <![CDATA[ */!function(){try{var t="currentScript"in document?document.currentScript:function(){for(var t=document.getElementsByTagName("script"),e=t.length;e--;)if(t[e].getAttribute("cf-hash"))return t[e]}();if(t&&t.previousSibling){var e,r,n,i,c=t.previousSibling,a=c.getAttribute("data-cfemail");if(a){for(e="",r=parseInt(a.substr(0,2),16),n=2;a.length-n;n+=2)i=parseInt(a.substr(n,2),16)^r,e+=String.fromCharCode(i);e=document.createTextNode(e),c.parentNode.replaceChild(e,c)}}}catch(u){}}();/* ]]> */</script></a>.</p>
        <p>Code released under the <a href="https://github.com/thomaspark/bootswatch/blob/gh-pages/LICENSE">MIT License</a>.</p>
        <p>Based on <a href="http://getbootstrap.com" rel="nofollow">Bootstrap</a>. Icons from <a href="http://fortawesome.github.io/Font-Awesome/" rel="nofollow">Font Awesome</a>. Web fonts from <a href="http://www.google.com/webfonts" rel="nofollow">Google</a>.</p>

      </div>
    </div>

  </footer>


</div>


<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<%--<script src="../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>--%>
<script src="../asserts/js/bootstrap.min.js"></script>
<script src="../asserts/js/bootswatch.js"></script>
<script type="text/javascript">
  /* <![CDATA[ */
  (function(){try{var s,a,i,j,r,c,l=document.getElementsByTagName("a"),t=document.createElement("textarea");for(i=0;l.length-i;i++){try{a=l[i].getAttribute("href");if(a&&a.indexOf("/cdn-cgi/l/email-protection") > -1  && (a.length > 28)){s='';j=27+ 1 + a.indexOf("/cdn-cgi/l/email-protection");if (a.length > j) {r=parseInt(a.substr(j,2),16);for(j+=2;a.length>j&&a.substr(j,1)!='X';j+=2){c=parseInt(a.substr(j,2),16)^r;s+=String.fromCharCode(c);}j+=1;s+=a.substr(j,a.length-j);}t.innerHTML=s.replace(/</g,"&lt;").replace(/>/g,"&gt;");l[i].setAttribute("href","mailto:"+t.value);}}catch(e){}}}catch(e){}})();
  /* ]]> */
</script>
</body>
</html>
