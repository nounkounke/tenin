package gn.moria.nounkouke.tenin.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum WalletType {
    SAVING("saving"),CHECKING("checking");

    private final String value;
}
