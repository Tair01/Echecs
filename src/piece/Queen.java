package piece;
import com.mypackage.Coordinates;
import com.mypackage.Color;
import com.mypackage.CoordinatesShift;

import java.util.Set;

public class Queen extends Piece {
    public Queen(Color color, Coordinates coordinates){
        super(color, coordinates);
    }

    protected Set<CoordinatesShift> getPieceMoves(){
        return null;
    }
}
