package piece;
import com.mypackage.Coordinates;
import com.mypackage.Color;
import com.mypackage.CoordinatesShift;

import java.util.Set;

public class Pawn extends Piece {
    public Pawn(Color color, Coordinates coordinates){
        super(color, coordinates);
    }
    protected Set<CoordinatesShift> getPieceMoves(){
        return null;
    }
}
