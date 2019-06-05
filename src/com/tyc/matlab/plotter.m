function plotter()
    x = linspace(0,1,100)';
    stem(sin(3/2*x*pi) + 5*cos(4/9*x*pi));