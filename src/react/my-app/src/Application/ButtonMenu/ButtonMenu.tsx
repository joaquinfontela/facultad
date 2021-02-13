import React from 'react';
import './ButtonMenu.css'
import { MenuButton } from './MenuButton/MenuButton'


interface ButtonMenuProps {
}

export class ButtonMenu extends React.Component<ButtonMenuProps> {

    render(): JSX.Element {
        return (
            <div className="buttonMenu">
                <MenuButton text="DISPONIBLES" />
                <MenuButton text="RESTANTES" />
                <MenuButton text="CREDITOS" />
                <MenuButton text="APROBADAS" />
            </div>
        );
    }
}