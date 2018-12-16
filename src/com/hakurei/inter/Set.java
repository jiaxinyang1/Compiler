package com.hakurei.inter;

import com.hakurei.parser.Stmt;
import com.hakurei.symbols.Id;
import com.hakurei.symbols.Type;

/**
 * @ClassName Set
 * @Description TODO
 * @Author hakurei
 * @Date 2018/12/15
 * @Version 1.0
 */
public class Set extends Stmt {
    public  Id id; public Expr expr;

    public Set(Id i, Expr x) {
        id =i;expr=x;

    }


}
